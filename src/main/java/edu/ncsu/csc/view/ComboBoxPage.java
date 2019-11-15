package edu.ncsu.csc.view;

import java.util.ArrayList;
import java.util.List;

public class ComboBoxPage extends BasePage {
    int selectIndex;
    String selecValue;

    private static ComboBoxPage instance;
    public static ComboBoxPage getInstance(){
        if(instance==null){
            instance=new ComboBoxPage();
        }
        return instance;
    }
    public int select(List<String> munu, String promp){
        this.choicePrompt=promp;
        this.menuStrs =munu;
        initPage();
        return getChoice();
    }
    public List<Integer> mutilSelect(List<String> munu, String promp){
        this.choicePrompt=promp;
        this.menuStrs =munu;
        List<Integer> indexes=new ArrayList<Integer>();
        initPage();
        String s=getStringFromInput("");
        String [] values=s.split(",");
        for(int i=0;i<values.length;i++){
            int v=Integer.parseInt(values[i]);
            if (v<= menuStrs.size()&& i>0) {
                indexes.add(Integer.parseInt(values[i]));
            }else{
                throw new NumberFormatException("input index is invalid");
            }
        }
        return indexes;
    }
    public int getSelectIndex() {
        return selectIndex;
    }

    public String getSelecValue() {
        return selecValue;
    }
}
