public class PieceKnight extends Piece{
	public Piece[][] moveknight(Piece K1, Piece h, Piece[][] t1){
		newstate = t1;
		newstate[h.cellx()][h.cellx()] = new PieceKnight(K1.type(), h.cellx(), h.cellx());
		newstate[K1.cellx()][K1.cellx()] = new EMPTY(0, K1.cellx(), K1.cellx());
		return newstate;
	}
	

	public PieceKnight(int type, int i1, int j1) {
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
	
	
	public String name = "Knight";
	public String imgname = "knight.png";
	private Piece[][] newstate;
	private int ix;
	private int jy;
}