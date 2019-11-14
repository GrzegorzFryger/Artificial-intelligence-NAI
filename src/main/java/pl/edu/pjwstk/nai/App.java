package pl.edu.pjwstk.nai;
import antlr.RuleBlock;
import net.sourceforge.jFuzzyLogic.FIS;
import net.sourceforge.jFuzzyLogic.FunctionBlock;
import net.sourceforge.jFuzzyLogic.plot.JFuzzyChart;
import net.sourceforge.jFuzzyLogic.rule.Variable;
/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {

        String fileName = "fcl/salary.fcl";
        FIS fis = FIS.load(fileName,true);

        // Error while loading?
        if( fis == null ) {
            System.err.println("Can't load file: '" + fileName + "'");
            return;
        }

        FunctionBlock functionBlock = fis.getFunctionBlock("salary");


        JFuzzyChart.get().chart(functionBlock);

        // Set inputs [1-10]
        fis.setVariable("experience", 3);
        fis.setVariable("coding_skill", 3);
        fis.setVariable("soft_skills", 8);

        fis.evaluate();


        Variable tip = functionBlock.getVariable("salary");
        JFuzzyChart.get().chart(tip, tip.getDefuzzifier(), true);

        System.out.println(fis);


    }
}
