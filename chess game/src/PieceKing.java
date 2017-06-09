public class PieceKing extends Piece {
	public Piece[][] moveking(Piece K, Piece h, Piece[][] t1){
		newstate = t1;
		
		newstate[h.cellx()][h.celly()] = new PieceKing(K.type(), h.cellx(), h.celly());
		newstate[K.cellx()][K.celly()] = new EMPTY(0, K.cellx(), K.celly());
		
		return newstate;
	}
	
	public PieceKing(int type, int i1, int j1) {
		super(type);
		ix = i1;
		jy = j1;
	}
	
	@Override
	public int cellx(){
		if(ix > 8){
		return 7;}
		
		if(ix < 0){
		return 0;}
		
		else{return ix;}
	}
	
	@Override
	public int celly(){
		if(jy > 8){
		return 7;}
		
		if(jy < 0){
		return 0;}
		
		else{return jy;}
	}
	
	@Override
	public String toString(){
		return name;
	}
	
	@Override
	public String imagefilename(){
		return imgname;
	}
	
	public String name = "King";
	public String imgname = "king.png";
	private Piece[][] newstate;
	private int ix;
	private int jy;

	
}