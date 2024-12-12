/**
 * Pictures are made up of pixels (picture elements)
 * 
 * The coordinate system is based on the 4th quadrant of the
 * euclidian system. (y increases downwards into the 
 * negative axis) There is no negative value however.
 * 
 * Shapes are drwan from rectangles, ovals, lines, arcs,
 * text, and polygons (requires arrays)
 * 
 * Height and width of shapes should be used as a percentage
 * of the window.
 * Ex. unit = width / 10 or height / 4 (25% of screen)
 * Graphics should have relative numbers, and not
 * specific to its shapes. (Do not put shapes in a
 * specific location)
 * This is called scaling
 * 
 * RGB values make up color values.
 * The Graphics class allows the paintComponent method.
 * setColor method allows changing the colors and is kept until
 * overwritten.
 * drawLine() method uses the current color between (x1, y1) and
 * (x2, y2)
 * drawRect() draws the outline of the rectangle
 * fillRect() fills the specified rectangle
 * drawOval() will draw the oval outline (from an imaginary outine)
 * A circle can be drawn by giving the same height and width
 * drawArc() requires a startAngle and arcAngle
 * 180 degrees and 270 degrees will form the arc of the 3rd quadrant
 * in the unit circle
 * 
 * For text, the drawString is used to draw in a rectange shaped area
 * int x = 10, y = 10
 * String text = "Hello!"
 */