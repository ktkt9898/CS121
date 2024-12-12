/*
 * Objects are compared by their address
 * Addresses are integers, so (==) is used to compare addresses
 * BUT to compare objects, use the compareTo method
 * compareTo returns something negative, 0, or something positive
 * 
 * A trick for finding mins and maxes is setting the count data point to
 * an already existing data point, like the first element in an array.
 * 
 * Interfaces allow more flexibility when comparing objects
 * 
 * When implementing compareTo an equals method should be created
 * in the interface, along with toString
 */