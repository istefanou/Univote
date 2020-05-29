package johnara.com.univote;

import java.util.Date;
import java.util.HashMap;
import java.util.List;

public class Psifoforia {
    private Katigoria katigoria;
    private String titlos;
    private Date startTime;
    private int msDuration;
    private List<Integer> votes ;
    private HashMap<Integer,String> choices;

    private int pollType;//0 for yes-no 1 for multiple options 2 for multiple options with the ability to add others


    public Psifoforia() {
    }

    public void setKatigoria(Katigoria katigoria) {
        this.katigoria = katigoria;
    }

    public void setPollType(int pollType) {
        this.pollType = pollType;
        if(pollType==0) {
            choices.put(1, "Yes");
            choices.put(2, "No");
        }
    }

    public void setStartTime(Date startTime) {
        this.startTime = startTime;
    }

    public void setTitlos(String titlos) {
        this.titlos = titlos;
    }

    public void setMsDuration(int minutesDuration) {
        this.msDuration = msDuration;
    }

    public Date getStartTime() {
        return startTime;
    }

    public int getPollType() {
        return pollType;
    }

    public String getTitlos() {
        return titlos;
    }

    public Katigoria getKatigoria() {
        return katigoria;
    }

    public int getMsDuration() {
        return msDuration;
    }

    public void addNewChoice(String new_choice){
        if (pollType!=0) choices.put(choices.size(),new_choice);
    }

    public void vote(int choice){
        votes.set(choice,votes.get(choice)+1);
    }

    public HashMap<Integer,String> getResults(){
        //Use choices hashmap and votes to return results
        return new HashMap<Integer, String>();
    }

    public void extendPoll(int extention_time){
        msDuration = msDuration + extention_time;
    }
}
