public class EMPTY extends Piece{
	private int i;
	private int j;
	private String name = "Empty";

	public EMPTY(int type, int ii, int jj) {
		super(type);
		i = ii;
		j = jj;
	}
	
	@Override
	public int cellx(){
		if(i > 8){
		return 7;}
		
		if(i < 0){
		return 0;}
		
		else{return i;}
	}
	
	@Override
	public int celly(){
		if(j > 8){
		return 7;}
		
		if(j < 0){
		return 0;}
		
		else{return j;}
	}
	
	@Override
	public String toString(){
		return name;
	}

}