package application;

import java.text.ParseException;
import java.text.SimpleDateFormat;

import entities.Comment;
import entities.Post;

public class Program {

	public static void main(String[] args) throws ParseException {
		
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
		
		Comment c1 = new Comment("Uau que incrível");
		Comment c2 = new Comment("Que legal!");
		
		Post p1 = new Post(sdf.parse("22/03/2022 15:54:33"), "Primeiro Post", "Conteudo do primeiro post", 2);
		
		p1.addComment(c1);
		p1.addComment(c2);
		
		System.out.println(p1);
	}

}
