package ExcelScenarios;

import java.util.ArrayList;
import java.util.List;

public class TagsAndScenarios {
    private List<String> scenariosList;
    private List<String> tagsList;
    private List<String> nameFileList;
    static String nameFile;


    public TagsAndScenarios() {
        this.tagsList = new ArrayList<String>();
        this.scenariosList = new ArrayList<String>();
        this.nameFileList = new ArrayList<String>();

        for (int i = 1; i <= 100; i++) {
            tagsList.add("TAG-" + i);
            scenariosList.add("Scenario: This is a long scenario description for the tag: TAG-" + i);

           switch (i){
               case 12:
                   nameFile = "Category from " + i;
                   break;

               case 30:
                   nameFile = "Category from " + i;
                   break;

               case 70:
                   nameFile = "Category from " + i;
                   break;
           }

            nameFileList.add(nameFile);

        }
    }

    public List<String> getScenariosList() {
        return scenariosList;
    }

    public void setScenariosList(List<String> scenariosList) {
        this.scenariosList = scenariosList;
    }

    public List<String> getTagsList() {
        return tagsList;
    }

    public void setTagsList(List<String> tagsList) {
        this.tagsList = tagsList;
    }

    public List<String> getNameFileList() {return nameFileList;}

    public void setNameFileList(List<String> nameFileList) {this.nameFileList = nameFileList;}
}
