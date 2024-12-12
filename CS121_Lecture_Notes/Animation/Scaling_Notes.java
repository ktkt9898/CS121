package Animation;
/**
 * Never have hard coded pixel values, incase of resizing.
 * Use the width and height of the screen.
 * Ex. frogDimension = 1/3*height (this acts as the anchor point)
 * frogEyeDim = 1/3 * frogDimension
 * Recall that an oval first makes a rectangle around it.
 * frogY = (1/2 * height) - (1/2 * frogDim)
 * (x0ffset, frogY)
 */