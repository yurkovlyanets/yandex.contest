package Test;

import java.io.*;
import java.util.Locale;

class Graph {
	String vertex1;
	String vertex2;
	int weight;	
	public Graph(String vertex1,String vertex2,int weight){
		this.vertex1=vertex1;
		this.vertex2=vertex2;
		this.weight=weight;
	}
}

class test1 {
	public static void main(String[] args)throws IOException {
		Locale.setDefault(Locale.US);
		BufferedReader br = new BufferedReader(new FileReader("input.txt"));
		String SubString[];
		int n = Integer.parseInt(br.readLine());
		int NumOfWords=0;
		String StrArr[] = new String[n];
		for(int i=0; i<n; i++){
			StrArr[i] = br.readLine();
			NumOfWords+=StrArr[i].length();
		}
		Graph[] graph = new Graph[NumOfWords-2*n];
		SubString=new String[NumOfWords];
		int k=0;
		for(int i=0; i<n; i++){
			for(int j=0; j<StrArr[i].length(); j++){
				if (i!=0){
					if (j==StrArr[i].length()-3){
						SubString[k]=StrArr[i].substring(j);
						break;
					}
					else SubString[k]=StrArr[i].substring(j,j+3);
				}
				else {
					if (j==StrArr[i].length()-3){
						SubString[k]=StrArr[i].substring(j);
						break;
					}
					else SubString[k]=StrArr[i].substring(j,j+3);
				}
				k++;
			}
			if (k==NumOfWords) break;
		}
		k=0;
		int i=0;
		boolean VertexReplay;
		do{
			VertexReplay=false;
			graph[k]=new Graph(" ", " ",0);
			for (int j=0; j<k; j++){
				if ((graph[j].vertex1.equals(SubString[i]))&&(graph[j].vertex2.equals(SubString[i+1]))){
					graph[j].weight++;
					VertexReplay=true;
					break;
				}
			}
			if (!VertexReplay){
				graph[k].vertex1=SubString[i];
				graph[k].vertex2=SubString[i+1];
				graph[k].weight=1;
				k++;
			}
			i++;
		}
		while (SubString[i+1]!=null);
		graph[k]=null;
		int NumOfVertex=0, NumOfEdge=0;
		k=0;
		while(graph[k]!=null){
			NumOfVertex++;
			NumOfEdge++;
			if (graph[k].vertex1.equals(graph[k].vertex2)){
				NumOfVertex--;
			}
			k++;
		}
		k=0;
		System.out.println(NumOfVertex + "\n" + NumOfEdge);
		do{
			System.out.println(graph[k].vertex1 + " " + graph[k].vertex2 + " " + graph[k].weight);
			k++;
		}
		while(graph[k]!=null);
	}
}
