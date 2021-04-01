package finalproject;

import java.util.HashMap;
import java.util.ArrayList;

public class SearchEngine {
    public HashMap<String, ArrayList<String> > wordIndex;   // this will contain a set of pairs (String, LinkedList of Strings)
    public MyWebGraph internet;
    public XmlParser parser;

    public SearchEngine(String filename) throws Exception{
        this.wordIndex = new HashMap<String, ArrayList<String>>();
        this.internet = new MyWebGraph();
        this.parser = new XmlParser(filename);
    }










    /*
     * This does a graph traversal of the web, starting at the given url.
     * For each new page seen, it updates the wordIndex, the web graph,
     * and the set of visited vertices.
     *
     * 	This method will fit in about 30-50 lines (or less)
     */





    public void crawlAndIndex(String url) throws Exception {
        internet.addVertex(url);
        internet.setVisited(url, true);


        ArrayList<String> u = parser.getContent(url);


        for (String s : u) {
            String lowerCaseString = s.toLowerCase();

            if (!(wordIndex.containsKey(lowerCaseString))) {
                wordIndex.put(lowerCaseString, new ArrayList<>());

            }
            if (!(wordIndex.get(lowerCaseString).contains(url))) {
                wordIndex.get(lowerCaseString).add(url);
            }

        }

        ArrayList<String> uu = parser.getLinks(url);

        for (String ss : uu) {
            if(!(this.internet.getVisited(ss))) {
                crawlAndIndex(ss);
            }
            internet.addEdge(url, ss);
        }

    }










    /*
     *
     * This computes the pageRanks for every vertex in the web graph.
     * It will only be called after the graph has been constructed using
     * crawlAndIndex().
     * To implement this method, refer to the algorithm described in the
     * assignment pdf.
     *
     * This method will probably fit in about 30 lines.
     */



    public void assignPageRanks(double epsilon) {

        ArrayList<String> v = internet.getVertices();

        Double rank = 1.0;


        for (String url : v) {
            if(internet.getPageRank(url)== 0.0) {
                internet.setPageRank(url, rank);
            }
        }


        boolean c = true;

        while(c) {
            int i = 0;
            c = false;
            ArrayList<Double> newArray = computeRanks(v);

            for (Double temp : newArray) {
                Boolean t = (Math.abs(internet.getPageRank(v.get(i)) - temp) < epsilon);
                if(!t) {
                    c = true;


                }
                internet.setPageRank(v.get(i), temp);
                i++;
            }
        }
    }












    /*
     * The method takes as input an ArrayList<String> representing the urls in the web graph
     * and returns an ArrayList<double> representing the newly computed ranks for those urls.
     * Note that the double in the output list is matched to the url in the input list using
     * their position in the list.
     */


    // figure it out the equation

    public ArrayList<Double> computeRanks(ArrayList<String> vertices) {
        ArrayList<Double> listOfRanks = new ArrayList<Double>();
        for (String url: vertices) {
            double r = 0.5;

            ArrayList<String> urls= this.internet.getEdgesInto(url);

            for (String s : urls) {

                double c = 0.5 * (this.internet.getPageRank(s) / this.internet.getOutDegree(s));
                r += c;

            }


            listOfRanks.add(r);
            this.internet.setPageRank(url, r);

        }
        return listOfRanks;
    }













    /* Returns a list of urls containing the query, ordered by rank
     * Returns an empty list if no web site contains the query.
     *
     * This method should take about 25 lines of code.
     */


    public ArrayList<String> getResults(String query) {
        //create a new hashmap
        HashMap<String, Double> r = new HashMap<>();

        for (String url : this.wordIndex.get(query)) {
            r.put(url, this.internet.getPageRank(url));
        }
        return Sorting.fastSort(r);
    }









}
