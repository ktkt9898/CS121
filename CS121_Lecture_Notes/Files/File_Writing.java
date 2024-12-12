/*
 * PrintWriter Class is an excellent class to write to a file.
 * Can take a File path or an Output Stream
 * 
 * Until a file is closed, there is no guarantee the file is written
 * to disk. This means the PrintWriter needs to be closed.
 * 
 * try {
 *  PrintWriter pw = new PrintWriter(new FileOutputStream(new File("text.txt"), true))
 *  pw.println("I wonder if thhis writes something to a new file?");
 *  pw.println("I think I did it!");
 *  pw.close();
 * }
 * 
 * Absolute paths only work for a specific machine, do not use absolute
 * paths.
 * Use relative paths instead by specifying ../<up one folder>
 * ../images/Earth.png
 */