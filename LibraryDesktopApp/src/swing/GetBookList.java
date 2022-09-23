package swing;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class GetBookList {
	//Here is our method to get a list of book objects to populate the front end
	public List<Book> GetBookList(String filepath) throws IOException {
		List<Book> bookList = new ArrayList<Book>(); //Creating the List to populate 
        BufferedReader reader =new BufferedReader(new FileReader(filepath));
        String currentLine;

        while ((currentLine = reader.readLine()) != null) {
        	Book b = new Book();
        	String[] bookDetailsArray;
        	//List<String> bookDetailsList = new ArrayList<String>();
        	bookDetailsArray = currentLine.split("[,]");
        	b.id = Integer.parseInt(bookDetailsArray[0]);
        	b.goodReadId = bookDetailsArray[1];
        	b.bestBookId = bookDetailsArray[2];
        	b.workId = bookDetailsArray[3];
        	b.booksCount = bookDetailsArray[4];
        	b.ibsn = bookDetailsArray[5];
        	b.ibsn13 = bookDetailsArray[6];
        	b.authors = bookDetailsArray[7];
        	b.orginalPublicationYear = bookDetailsArray[8];
        	b.orginalTitle = bookDetailsArray[9];
        	b.title = bookDetailsArray[10];
        	b.languageCode = bookDetailsArray[11];
        	b.averageRating = bookDetailsArray[12];
        	b.ratingsCount = bookDetailsArray[13];
        	b.workRatingsCount = bookDetailsArray[14];
        	b.workTextReviewsCount = bookDetailsArray[15];
        	b.ratings1 = bookDetailsArray[16];
        	b.ratings2 = bookDetailsArray[17];
        	b.ratings3 = bookDetailsArray[18];
        	b.ratings4 = bookDetailsArray[19];
        	b.ratings5 = bookDetailsArray[20];
        	b.imageURl = bookDetailsArray[21];
        	
        	bookList.add(b);
        	
        }
        return bookList;
	}
	
}
