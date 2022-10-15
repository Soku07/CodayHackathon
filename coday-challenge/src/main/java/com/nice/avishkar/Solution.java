package com.nice.avishkar;

//import java.nio.file.Path;
import java.nio.charset.StandardCharsets;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Scanner;
import java.io.*;


public class Solution {

	public ElectionResult execute(Path candidateFile, Path votingFile) {
		ElectionResult resultData = new ElectionResult();
		try {
			@SuppressWarnings("resource")
			Scanner sc = new Scanner(System.in);
			BufferedReader candidateReader = Files.newBufferedReader(candidateFile, StandardCharsets.UTF_8);
			
			String lines; //to read lines from file
			boolean flag = false; // incase record is not found
			
			System.out.print("Enter Roll Number to be searched:");
			String searchRoll = sc.next();
			
			try {
				while ((lines =candidateReader.readLine()) != null) {
					String [] line = lines.split(",");
					if (searchRoll.equals(line[0])) {
						System.out.println("Record Found");
						System.out.println(lines);
						flag = true;
						break;
					}
				}
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			if (flag == false) {
				System.out.println("Record not found :(");
			}
			
			try {
				candidateReader.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("File Not Found!");
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		return resultData;
	}
	
	
	public static void main(String[] args) {
		Path candidatePath = FileSystems.getDefault().getPath("src/main/resources", "candidateFile.csv");
		Path votingPath = FileSystems.getDefault().getPath("src/main/resources", "votingFile.csv");
		Solution trial = new Solution();
		trial.execute(candidatePath, votingPath);
	}

}