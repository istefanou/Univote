package johnara.com.univote;

import java.util.Date;

public class Minima_Forum {
    private String minima;
    private Date timeSent;
    private int forum_id;
    public Minima_Forum (String minima,Date timeSent,int id){
        this.minima = minima;
        this.timeSent = timeSent;
        this.forum_id = id;
    }

    public Date getTimeSent() {
        return timeSent;
    }

    public String getMinima() {
        return minima;
    }

    public int getForum_id() {
        return forum_id;
    }
}
