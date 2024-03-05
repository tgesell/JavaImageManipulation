/* 
 * A superclass that contains basic functionality for all filers,
 * and a method (modifyPixels()) which should be overridden by each of the 
 * specific Filter subclasses
 * We could make this class abstract - but as that is not an AP CS-A topic, it is written
 * as a concrete (normal, not abstract) class.
 */
public class Filter
{
    /**
     * Modify the image according to your algorithm
     * 
     * @param  theImage The image to modify
     */
    
    Pixel[][] data;
    
    public void filter(PixelImage theImage)
    {
       data = theImage.getData(); 
       if (data != null)
       {
           modifyPixels();
           theImage.setData(data);
       }
    }
    
    //protected is not tested on the AP exam, but means that it can only be accessed by this class and its subclasses
    //give access to the 2D array of Pixels to the subclasses
    protected Pixel[][] getData()
    {
        return data;
    }
    
    //allow the 2D array of Pixels to be replaced by the subclasses
    protected void setData(Pixel[][] data)
    {
        this.data = data;
    }   
    
    //override this method in the subclasses
    protected void modifyPixels()
    {
        //the default filter does nothing.
        //override this method in your child classes, to do something.
    }
    
}
