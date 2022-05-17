public class Tools {
    //String with info/task for tool
    String info, task;
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
    public Tools(String i, String t, int d){
        info=i;
        task=t;
        damage=d;
    }
}
