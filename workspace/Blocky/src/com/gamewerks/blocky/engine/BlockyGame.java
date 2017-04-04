package com.gamewerks.blocky.engine;

import java.util.Random;

import com.gamewerks.blocky.util.Constants;
import com.gamewerks.blocky.util.Position;

public class BlockyGame {
	private static final int LOCK_DELAY_LIMIT = 30;

	private Board board;
	private Piece activePiece;
	private Direction movement;
	private int index = 8;

	private int lockCounter;

	public BlockyGame() {
		board = new Board();
		movement = Direction.NONE;
		lockCounter = 0;
		trySpawnBlock();
	}

	private void shuffle(PieceKind[] arr, PieceKind[] ret, int n) {
		if (n < ret.length && arr.length > 0) {
			Random rand = new Random();
			int len = arr.length - 1;
			int ind = rand.nextInt(arr.length);
			PieceKind[] arr2 = new PieceKind[len];
			for (int j = 0; j < arr.length; j++) {
				if (j < ind) {
					arr2[j] = arr[j];
				} else if (j > ind) {
					arr2[j - 1] = arr[j];
				}
			}
			ret[n] = arr[ind];
			shuffle(arr2, ret, n + 1);
		}
	}

	private void trySpawnBlock() {
		if (index >= PieceKind.ALL.length) {
			int n = 0;
			shuffle(PieceKind.ALL, PieceKind.ALL, n);
			index = 0;
		}
		if (activePiece == null) {
			activePiece = new Piece(PieceKind.ALL[index], new Position(3, Constants.BOARD_WIDTH / 2 - 2));
			if (board.collides(activePiece)) {
				System.exit(0);
			}
			index++;
		}
	}

	private void processMovement() {
		Position nextPos;
		switch (movement) {
		case NONE:
			nextPos = activePiece.getPosition();
			break;
		case LEFT:
			nextPos = activePiece.getPosition().add(0, -1);
			break;
		case RIGHT:
			nextPos = activePiece.getPosition().add(0, 1);
			break;
		default:
			throw new IllegalStateException("Unrecognized direction: " + movement.name());
		}
		if (!board.collides(activePiece.getLayout(), nextPos)) {
			activePiece.moveTo(nextPos);
		}
	}

	private void processGravity() {
		Position nextPos = activePiece.getPosition().add(1, 0);
		if (!board.collides(activePiece.getLayout(), nextPos)) {
			lockCounter = 0;
			activePiece.moveTo(nextPos);
		} else {
			if (lockCounter < LOCK_DELAY_LIMIT) {
				lockCounter += 1;
			} else {
				board.addToWell(activePiece);
				lockCounter = 0;
				activePiece = null;
			}
		}
	}

	private void processClearedLines() {
		board.deleteRows(board.getCompletedRows());
	}

	public void step() {
		trySpawnBlock();
		processGravity();
		processClearedLines();
	}

	public boolean[][] getWell() {
		return board.getWell();
	}

	public Piece getActivePiece() {
		return activePiece;
	}

	public void setDirection(Direction movement) {
		this.movement = movement;
		this.processMovement();
	}

	public void rotatePiece(boolean dir) {
		if (!board.collides(activePiece.getFutureLayout(dir), activePiece.getPosition()))
			activePiece.rotate(dir);
	}
}
