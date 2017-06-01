#Solving State Elimination Problem as Model Transformation using Epsilon Created for TCC 2017

Implementation for the state elimination algorithm described in the paper can be downloaded from easychair website: http://www.easychair.org/

Required resources are included in project:

1)Java runtime environment 1.8 (or greater)

2)ir.ui.mdserg.StateElimination is an EMF project which uses Epsilon framework and includes

    Metamodel of Transition graphs
    EMF instance models under ..testdata/emf for each specific tasks
    Scripts for doing transformations
    Ant builder files for each specific tasks
        To execute Main Task, you should run RunMainTask.xml
        To execute Extension 1 Task, you should run RunExtension1xml

To see how the implemented Main Task work, we create an Ant build file (MainTask.xml) which defines the workflow of transformation chains. By executing the Ant builder from "Run" in Eclipse toolbar, equivalent regular expression for input model (e.g. leader3_2.xmi) generated and saved as a text file (e.g. ER_leader3_2.txt) in project directory.

Hint: If your build failed, Right-click on the build file and from: Run As > External Tools Configurations > JRE, set Runtime JRE to "Run in the same JRE as the workspace".
