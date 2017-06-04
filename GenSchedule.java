class sample{
//generates a schedule for student, int value in array - a floor number,
//"-1" if no class. seed - a number associated with an academic group
//to generate the same schedules. Groups have maximum 1 window.
int[] genScedule(int course, int seed){
    //changeable parameters
    int maxClasses = 6;
    int maxLoad = 4;

    int start = seed % (maxClasses-maxLoad);
    int w = seed % (maxClasses);
    int window = w == course? w+1: w;

    int[] schedule = new int[maxClasses];
    for(int i=0; i<maxClasses; i++)
      schedule[i]=-1;

    int count = 0;

    for(int i=0; i < maxClasses && count < maxLoad; i++){

     if(i >= start && i != window){
        if(i==course)
          schedule[i]=10;
        else
          schedule[i]=(720 * (i+1) + seed) % 11 + 1;   
        count++;
     }
    }
    return schedule;
}
}