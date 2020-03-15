package lucastorie;

import java.util.ArrayList;
import java.util.List;

import org.jblas.DoubleMatrix;

import glove.GloVe;
import glove.objects.Cooccurrence;
import glove.objects.Vocabulary;
import glove.utils.Options;

public class Glove {
	
	
	public static void createGlove(String file,ArrayList<String> termoQueroinput, int iterations, int WS) {
		
	
		Options options = new Options();
		
		options.debug=true;
        
        Vocabulary vocab = GloVe.build_vocabulary(file, options); //Retira todas as palavras pela identifcacao do caractere ''espaço''
        
        options.window_size = WS;
        List<Cooccurrence> c =  GloVe.build_cooccurrence(vocab, file, options);
        
        options.iterations = iterations;
        options.vector_size = 100; //tamanho do vetor de cada palavra?
        options.debug = true;
        DoubleMatrix W = GloVe.train(vocab, c, options);  
        

       // List<String> similars = Methods.most_similar(W, vocab, "user", 50);

        /* for(String similar : similars) {
            System.out.println("@" + similar);
        }
        */
        
              
        double [][] X = W.toArray2();
        
        double [][] mWtrans = new double [X[0].length][X.length];
        
       // System.out.println( X.length + " " + X[0].length );
       
        //MATRIZ TRANSPOSTA DE X:
        for(int j=0;j<X.length;j++) {
        	for(int x=0;x<X[0].length;x++) {
        		
        		mWtrans [x][j] = X [j][x];
        	}
        }
      
        //System.out.println( mWtrans.length + " " + mWtrans[0].length );
       
       // System.out.println( vocab. );
       // TSneTest.Lets(mWtrans,vocab);
        TSne.Lets(mWtrans,vocab,termoQueroinput);
		
	}

}
