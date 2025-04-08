# 🔍 Java Search Engine Simulator

A simplified yet powerful search engine simulation built in Java. This project replicates core search engine mechanics—like web crawling, indexing, ranking, and result sorting—based on a PageRank-style algorithm. Designed to showcase proficiency in object-oriented design, graph algorithms, and XML parsing.

---

## 💡 Project Overview

This Java program builds and navigates a **web graph**, parsed from XML files that simulate interlinked web pages. It computes rankings based on link structure and keyword frequency, then processes queries to return the most relevant pages.

---

## 🛠️ Key Features

- **XML-based Web Crawler**  
  Parses a structured XML file that defines the network of pages and their contents.

- **Graph Construction (`MyWebGraph.java`)**  
  Builds a directed graph using adjacency lists and computes ranks based on incoming/outgoing links.

- **Search Engine Interface (`SearchEngine.java`)**  
  Accepts queries, identifies relevant pages by keyword, and returns a sorted list based on computed ranks.

- **Custom Sorting (`Sorting.java`)**  
  Implements a flexible comparator to sort results by relevance, rank, or other criteria.

---

## 📂 Main Components

- `SearchEngine.java` – Main entry point for search queries.
- `MyWebGraph.java` – Graph structure & rank computation.
- `XmlParser.java` – Reads and interprets XML files into page/link structures.
- `Sorting.java` – Handles result sorting based on rank or frequency.
- `test.xml`, `testAcyclic.xml` – Example input datasets (XML web graphs).

---

## 🚀 Getting Started

### Prerequisites
- Java JDK 8 or higher

### Compile the Program
```bash
javac *.java
```

### Run a Test
```bash
java SearchEngine test.xml
```

You can replace `test.xml` with your own XML-structured dataset.

---

## 🧠 Skills Demonstrated

This project highlights:
- ✅ Java OOP principles (inheritance, encapsulation, interfaces)
- ✅ Graph structures and PageRank-style algorithms
- ✅ XML parsing and file I/O
- ✅ Custom comparator and sorting mechanisms
- ✅ Clean modular code design

---

## 📊 Sample Use Case

Given the XML structure:
```xml
<page name="Home">
  <link page="About"/>
  <link page="Contact"/>
  <content>search engine simulation java project</content>
</page>
```

A query for `"search"` would return "Home" ranked above other pages depending on keyword match and incoming links.

---

## 📜 License

MIT License

---

## ✍️ Author

Developed by Vitoria Soria

---

## 👀 Want to See It in Action?

Try using your own XML dataset with multiple interconnected pages and varied keywords. It's a great way to demonstrate algorithmic thinking and system design during interviews.
