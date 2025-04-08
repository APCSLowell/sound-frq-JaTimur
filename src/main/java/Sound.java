import java.util.*;
public class Sound
{
  /** the array of values in this sound; guaranteed not to be null */
  int[] samples;



  /** Changes those values in this sound that have an amplitude greater than limit.
   *  Values greater than limit are changed to limit.
   *  Values less than -limit are changed to -limit.
   *  @param limit the amplitude limit
   *         Precondition: limit >= 0
   *  @return the number of values in this sound that this method changed
   */
  public int limitAmplitude(int limit)
  {  
    int change=0;
    for(int n=0;n<samples.length;n++){
      if(samples[n]>limit){
        samples[n]=limit;
        change++;
      }
      else if(samples[n]<limit*-1){
        samples[n]=limit*-1;
        change++;
      }
    }
    return change;
  }



  /** Removes all silence from the beginning of this sound.
   *  Silence is represented by a value of 0.
   *  Precondition: samples contains at least one nonzero value
   *  Postcondition: the length of samples reflects the removal of starting silence
   */
  public void trimSilenceFromBeginning()
  {
    int start=0;
    for(int n=0;n<samples.length;n++){
      if(samples[n]!=0){
        start=n;
        break;
      }
    }
    int[] list=new int[samples.length-start];
    for(int n=0;n<list.length;n++){
      list[n]=samples[n+start];
    }
    samples=list;
  }
}
