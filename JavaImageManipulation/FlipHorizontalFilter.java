/**
 * Filter that flips the image horizontally.
 */
public class FlipHorizontalFilter extends Filter
{
    public void modifyPixels() {
        Pixel[][] data = super.getData(); //super. is not really needed here, but just making it clear that getData is in the super class

        for (int row = 0; row < data.length; row++) {
            for (int col = 0; col < data[row].length / 2; col++) {
                Pixel temp = data[row][col];
                data[row][col] = data[row][ data[row].length - col - 1 ];
                data[row][ data[row].length - col - 1 ] = temp;
            }
        }
    }
}
