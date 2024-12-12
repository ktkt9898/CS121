/*
 * The file class is used to represent where the file lives... the
 * file path
 * 
 * import File class
 * 
 * File file = new File("data.txt");
 * 
 * if(file.exists() && file.isFile()){
 *  System.out.println();
 * }
 * else {
 *  System.out.println("Not valid")
 * }
 * 
 * Reading Text Files...
 * 
 * Scanner(File source)
 * 
 * Iterate using a while loop:
 * while(fileScan.hasNextLine()){
 * String line = fileScan.nextLine();
 * }
 * 
 * Exceptions are a way to "break" the program
 * It is thrown when Java does not know what to do
 * Ex. access an element that does not exist in an array
 * 
 * To handle exceptions use try and catch blocks
 * 
 * try {
 *  //attempt to open a file
 * }
 * catch (FileNotFoundException e)  {
 *  // Only catches a file not found exception
 * }
 * 
 * Exceptions is not a way to avoid poorly written code.
 * The exception is used when an outcome could possibly happen,
 * like no file found
 */
