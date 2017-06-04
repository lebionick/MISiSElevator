import javax.net.ssl.ExtendedSSLSession;

class sample{
//hours, minutes - время ближайшей пары
double getExpIntensity(int hours, int minutes){
    //считается что модельное время начинается в понедельник в 0:00,
    //измеряется в минутах и каждую неделю пары проходят одинаково
    int mininweek = (60*24*7);
    int mininday = (60*24);
    int weektime = time() % mininweek;
    int daytime = time() % mininday;
    int dayofweek = weektime / mininday + 1;
    //changeable
    int workdaybase = 3;
    int saturdaybase = 2;
    int sundaybase = 1; //sunday has no distrib
    int base;

    if(dayofweek>=1 && dayofweek<=5)
        base=workdaybase;
    else if(dayofweek==6)
        base=saturdaybase;
    else
        return sundaybase;
    //in minutes, how early a queue hits peak before class
    //changeable
    int delta = 5;
    double average = hours * 60 + minutes - delta;
    //changeable
    double deviation = 2.0;
    
    return normalDistr(average, deviation, daytime) * base + base;
}
double normalDistr(double aver, double dev, double t){
    return Math.exp(-Math.pow((aver-t)/dev,2)/2.0)/(dev*Math.sqrt(2*Math.PI));
}
int time();
}