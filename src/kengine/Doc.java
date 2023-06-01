package kengine;

import java.util.Iterator;
import java.util.Vector;

import utils.NotImplementedException;
import utils.NotPossibleException;


/**
 * @overview A document contains a title and a text body
 * 
 * @see "Program Development in Java", pgs: 314,322,333
 * @version 1.0
 * @author dmle
 * 
 */
public class Doc {
  private String d; // the document content
  private String title; // the document title
  private String body; // the document body

  /**
   * Constructor method
   * 
   * @param d
   *          A string that contains the document content
   * @effects if d cannot be processed as a document throws
   *          <code>NotPossibleException</code> else makes <code>this</code> be
   *          the <code>Doc</code> corresponding to <code>d</code>
   * 
   */
  public Doc(String d) throws NotPossibleException {
    // check that d is an HTML file
    // stores this content for processing later
    this.d = d;
  }

  /**
   * A method to return the title of this document.
   * 
   * @effects returns the title of <code>this</code>
   */
  public String title() {
    // scans the document content once to extract its title
    // stores the title into the title attribute to use later
    if (title == null) {
      // note that we donot scan the entire body at this stage,
      // only up to the <title> tag
      int tind1 = d.indexOf("<title>");
      int tind2 = d.indexOf("</title>"); // must be well-formed
      if (tind1 < 0) {
        tind1 = d.indexOf("<TITLE>"); // possibly upper case
        tind2 = d.indexOf("</TITLE>");
      }

      if (tind1 >= 0 && tind2 >= 0) {
        // extract only the title text
        title = d.substring(tind1 + 7, tind2);
      }
    }

    return title;
  }

  /**
   * A method to return the body of this document.
   * 
   * @effects returns the body of <code>this</code>
   */
  public String body() {
    // scans the document content once to extract its body
    // stores the body into the body attribute to use later
    if (body == null) {
      // note that we donot scan the entire body at this stage,
      // only up to the <title> tag
      int bind1 = d.indexOf("<body");
      int bind2 = d.indexOf("</body>"); // must be well-formed
      if (bind1 < 0) {
        bind1 = d.indexOf("<BODY"); // possibly upper case
        bind2 = d.indexOf("</BODY>");
      }

      if (bind1 >= 0 && bind2 >= 0) {
        // we want to keep the <body</body> tag pairs in
        // the body text
        body = d.substring(bind1, bind2 + 7);
      }
    }

    return body;
  }

  /**
   * A method that is used to iterate over all the words in <code>this</code> in the order
   * that they appear. 
   * 
   * @effects If <code>body == null</code> returns null, else
   *          returns a generator that will yield all the words in the document
   *          as strings in the order they appear in the text
   *          <p>
   * 
   *          This implementation also parses the Javascript text that is
   *          contained between the <code>&lt;script&gt;&lt;/script&gt;</code>
   *          tags.
   * @version 3.0: added this method
   */
  public Iterator words() {
    // stub
    return null;
  }

  public String toString() {
    return title();
  }
}
