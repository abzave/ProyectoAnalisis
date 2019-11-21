package control;

import lib.IConstants;
import ui.DrawableAnt;
import ui.DrawableThree;
import ui.MainFrame;
import ui.MainPanel;

import java.util.ArrayList;
import java.util.Collections;

public class Controller extends Thread{

    private ArrayList<DrawableThree> drawableThrees;
    private ArrayList<DrawableAnt> drawableAnts;
    private ArrayList<Result> results;
    private MainPanel mainPanel;
    private MainFrame mainFrame;
    private int totalTime;
    private int total;
    private int leafs;

    public Controller(ArrayList<Result> pResults){
        drawableThrees = new ArrayList<>();
        drawableAnts = new ArrayList<>();
        results = pResults;
        total = results.size()*IConstants.RESULT_PERCENTAGE_EXTRACTION/100;
        Collections.shuffle(results);
        for(int resultIndex = 0; resultIndex < total; resultIndex++) {
            Result result = results.get(resultIndex);
            totalTime += (2 * (result.getThree().getX() + result.getThree().getDepth()) + IConstants.ANT_SIZE * result.getTotalAnts()) / IConstants.ANT_MAX_SPEED;
        }
        leafs = countLeafs();
    }

    private int countLeafs(){
        int leafs = 0;
        for(Result result : results){
            leafs += result.getTotalAnts();
        }
        return leafs;
    }

    public void setUI(MainFrame pMainFrame, MainPanel pMainPanel){
        mainFrame = pMainFrame;
        mainPanel = pMainPanel;
    }

    public ArrayList<DrawableThree> getDrawableThrees() {
        return drawableThrees;
    }

    public ArrayList<DrawableAnt> getDrawableAnts() {
        return drawableAnts;
    }

    @Override
    public void run(){
        int recollected = 0;
        mainFrame.setLeafs(leafs);
        mainFrame.setPending(leafs);
        mainFrame.setBrought(recollected);
        for(int tree = 0; tree < results.size(); tree++){
            drawableThrees.add(new DrawableThree(results.get(tree).getThree()));
        }
        for(int resultIndex = 0; resultIndex < total; resultIndex++){
            Result result = results.get(resultIndex);
            double endTime = (2*(result.getThree().getX()+result.getThree().getDepth())+IConstants.ANT_SIZE*result.getTotalAnts())/IConstants.ANT_MAX_SPEED;
            try {
                mainFrame.repaint();
                for(DrawableAnt ant : drawableAnts){
                    ant.move();
                }
                drawableAnts.add(new DrawableAnt(IConstants.ANTTHILL, IConstants.ANT_WIDTH, IConstants.ANT_WIDTH));
                for(int second = 0; second < endTime; second++){
                    Thread.sleep(10);
                    mainFrame.setTime(totalTime--);
                    if(totalTime < 1){
                        break;
                    }
                }
            } catch (InterruptedException ignored) {}
        }
        System.out.println("End");
    }

}
