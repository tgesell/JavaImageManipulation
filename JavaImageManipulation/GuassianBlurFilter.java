public class GuassianBlurFilter extends Filter
{
    public void modifyPixels() {
        Pixel[][] data = getData();
        //we will need to leave the original pixels in place until we generate
        //all of the modified pixels, so we need a new Pixel[][]
        Pixel[][] modifiedData = new Pixel[data.length][data[0].length];

        //first and last rows, and first and last columns stay the same.
        //1) set first and last rows of modifiedData to same as data
        for(int col=0; col<data[0].length; col++)
        {
            modifiedData[0][col] = data[0][col];
            modifiedData[data.length-1][col] = data[data.length-1][col];
        }
        //2) set first and last columns of modifiedData to same as data


        //3) now set all of the rest of the pixels, to calculation that 
        //uses weighted values of the original pixel, and the pixels around it.
        // 1 2 1
        // 2 4 2
        // 1 2 1
        
        //uncomment the below line to set the imagePanel's image
        //to the new modified Pixel[][] modifiedData
        //setData(modifiedData);
    }
}
