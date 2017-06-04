void go(int floor){
    if(floor != 1){
        //logic
    }
}
//help: liftStages - 0...10
//floors 0...9
//flootNumber 2...11
//toUpList 0..10
void logic(){
    int nextfloor = -1;
    if(liftDirections.get(0) == "Вверх"){
        for(int i = liftStages.get(0) - 1; i < 11; i++){
            if(toUpList.get(i) != false){
                nextfloor = i + 1;
                break;
            }
        }
        if(nextfloor == -1){
            for(int i = liftStages.get(0) - 1; i < 11; i++){
                if(toDownList.get(i) != false){
                    nextfloor = i + 1;
                    break;
                }
            }
        }
        if(nextfloor == -1){
            liftDirections.set(0, "Вниз");
        }
    } else {
        for(int i = liftStages.get(0) - 1; i >= 0; i--){
            if(toDownList.get(i) != false){
                nextfloor = i + 1;
                break;
            }
        }
        if(nextfloor == -1){
            for(int i = liftStages.get(0) - 1; i < 11; i++){
                if(toUpList.get(i) != false){
                    nextfloor = i + 1;
                    break;
                }
            }
        }
        if(nextfloor == -1){
            liftDirections.set(0, "Вверх");
        }
    }
    go(nextfloor);
}