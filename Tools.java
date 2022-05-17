import java.util.ArrayList;

public class Tools {
    //String with info/task for tool
    String name, info, task;
    //how much damage
    int damage;

    /**
     * temp constructor
     */
    public Tools(){
        info="This is a tool.";
        task="To use this tool, do this";
        damage=5;
    }

    /**
     * constructor with parameters
     * @param i info string
     * @param t task string
     * @param d damage int
     */
    public Tools(String n, String i, String t, int d){
        name=n;
        info=i;
        task=t;
        damage=d;
    }

    public String getName(){return name;}
    public String getInfo(){return info;}
    public String getTask(){return task;}



}
