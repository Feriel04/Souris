package engine.map;

/**
 * Copyright SEDAMOP - Software Engineering
 * 
 * @author rouas,malek
 *
 */
public class Map {
	private Block[][] blocks;
	private int[][] herbe;
	private int lineCount;
	private int columnCount;

	public Map(int lineCount, int columnCount) {
		
		this.lineCount = lineCount;
		this.columnCount = columnCount;

		blocks = new Block[lineCount][columnCount];
		herbe = new int[lineCount][columnCount];
		for (int lineIndex = 0; lineIndex < lineCount; lineIndex++) {
			for (int columnIndex = 0; columnIndex < columnCount; columnIndex++) {
				blocks[lineIndex][columnIndex] = new Block(lineIndex, columnIndex);
				herbe[lineIndex][columnIndex] = getRandomNumber(0, 1);
			}
		}
	}
	
	

	public Block[][] getBlocks() {
		return blocks;
	}

	public int getLineCount() {
		return lineCount;
	}

	public int getColumnCount() {
		return columnCount;
	}
	
	public Block getBlock(int line, int column) {
		return blocks[line][column];
	}

	public boolean isOnTop(Block block) {
		int line = block.getLine();
		return line == 0;
	}

	public boolean isOnBottom(Block block) {
		int line = block.getLine();
		return line == lineCount - 1;
	}

	public boolean isOnLeftBorder(Block block) {
		int column = block.getColumn();
		return column == 0;
	}

	public boolean isOnRightBorder(Block block) {
		int column = block.getColumn();
		return column == columnCount - 1;
	}

	public boolean isOnBorder(Block block) {
		return isOnTop(block) || isOnBottom(block) || isOnLeftBorder(block) || isOnRightBorder(block);
	}
	private static int getRandomNumber(int min, int max) {
        return (int) (Math.random() * (max + 1 - min)) + min;
    }

	public int getHerbe(int i,int j) {
		return herbe[i][j];
	}

	public void setHerbe(int i,int j,int herbe) {
		this.herbe[i][j] = herbe;
	}
	
}
