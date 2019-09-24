/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package commandpattern;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Vihan Melaka 170387f
 */
 
interface Execute{
	void executeCommand();
}

class Operations{
	public void insert(String position, String item){
		System.out.println(item+" inserted at position "+position);
	}
	
	public void delete(String position, String item){
		System.out.println(item+" deleted at position "+position);
	}
	
	public void bold(String position, String item){
		System.out.println(item+" bolded at position "+position);
	}
	
	public void italic(String position, String item){
		System.out.println(item+" made italic at position "+position);
	}
}

class InsertItem implements Execute{
	private Operations ope;
	private String position;
	private String item; 
	
	public InsertItem (Operations ope){
		this.ope = ope;
	}
	
	public void putData(String position,String item){
		this.position = position;
		this.item=item;
	}
	
	public void executeCommand(){
		ope.insert( position, item);
	}
}

class DeleteItem implements Execute{
	private Operations ope;
	private String position;
	private String item; 
	
	public DeleteItem (Operations ope){
		this.ope = ope;
	}
	
	public void putData(String position,String item){
		this.position = position;
		this.item=item;
	}
	
	public void executeCommand(){
		ope.delete(position, item);
	}
}

class BoldItem implements Execute{
	private Operations ope;
	private String position;
	private String item; 
	public BoldItem (Operations ope){
		this.ope = ope;
	}
	
	public void putData(String position,String item){
		this.position = position;
		this.item=item;
	}
	
	public void executeCommand(){
		ope.bold(position, item);
	}
}

class ItalicItem implements Execute{
	private Operations ope;
	private String position;
	private String item; 
	public ItalicItem (Operations ope){
		this.ope = ope;
	}
	
	public void putData(String position,String item){
		this.position = position;
		this.item=item;
	}
	
	public void executeCommand(){
		ope.italic(position, item);
	}
}

class Handler{
	private List<Execute> executeList = new ArrayList<Execute>();
	
	public void takeExecute(Execute execute){
		executeList.add(execute);
	}
	
	public void placeExecutes(){
		for(Execute execute : executeList){
			execute.executeCommand();
		}
		executeList.clear();
	}
}

public class CommandPattern{
	public static void main(String [] args){
		Operations myOpe = new Operations();
		
		InsertItem ii = new InsertItem(myOpe);
		DeleteItem dd = new DeleteItem(myOpe);
		BoldItem bb = new BoldItem(myOpe);
		ItalicItem it = new ItalicItem(myOpe);
		
                ii.putData("3","a");
                it.putData("5", "vihan");
		Handler hh =new Handler();
		
		hh.takeExecute(ii);
		hh.takeExecute(it);
		
		hh.placeExecutes();
	}
}
