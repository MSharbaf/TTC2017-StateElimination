package test;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Random;

import org.eclipse.emf.common.util.EList;

import transitiongraph.State;
import transitiongraph.Transition;
import transitiongraph.TransitionGraph;

public class Tester extends TestFramework{
	
	public static void main(String[] args)
	{
		System.out.println("Test started ...") ; 
		Tester t = new Tester(); 
		try {
			t.testFSAToRegexAllModels();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("Test finished ...") ; 
	}
	
	public String FSAToRegex(String modelName){
		String ERE = "" ; 
		String REFile = "testresult/RE_"+ modelName+ ".txt" ; 
		BufferedReader reader;
		
		try{
			reader = new BufferedReader(new FileReader(REFile));
			StringBuilder sb = new StringBuilder();
			String line = "";
			while((line = reader.readLine()) != null){
				sb.append(line) ;
				line = reader.readLine();
			}
			ERE = sb.toString() ; 
			reader.close();
		} catch (Exception e){
			System.out.println( modelName + " ER file Not Found") ;
		}

		return ERE ; 
	}
	
	public String DTMCToSRE(String modelName){
		return "";
	}
	
	public String getAcceptedWordFromAutomaton(TransitionGraph tg, int maxLength){
		String word = "";
		String longestAcceptingWord = null;
		EList<State> states = tg.getStates();
		EList<Transition> transitions;
		Random rand = new Random();
		Transition nextTransition;
		int count = 0;
		State currentState = null;
		
		for(State s: states){
			if(s.isIsInitial()){
				currentState = s;
				break;
			}
		}
		
		while(count < maxLength){
			transitions = currentState.getOutgoing();
			nextTransition = transitions.get(rand.nextInt(transitions.size()));
			word = word + nextTransition.getLabel();
			currentState = nextTransition.getTarget();
			
			if(currentState.isIsFinal()) longestAcceptingWord = word;
			
			count++;
		}
		
		return longestAcceptingWord;
	}
	
	public String getNotAcceptedWordFromAutomaton(TransitionGraph tg, int maxLength){
		String word = "";
		String longestNotAcceptingWord = null;
		EList<State> states = tg.getStates();
		EList<Transition> transitions;
		Random rand = new Random();
		Transition nextTransition;
		int count = 0;
		State currentState = null;
		
		for(State s: states){
			if(s.isIsInitial()){
				currentState = s;
				break;
			}
		}
		
		while(count < maxLength){
			transitions = currentState.getOutgoing();
			nextTransition = transitions.get(rand.nextInt(transitions.size()));
			word = word + nextTransition.getLabel();
			currentState = nextTransition.getTarget();
			
			if(!currentState.isIsFinal()) longestNotAcceptingWord = word;
			
			count++;
		}
		
		return longestNotAcceptingWord;
	}
	
}
