package com.romeo.chess;

import java.util.logging.Level;
import java.util.logging.Logger;

public class Pawn {

    private static final Logger logger = Logger.getLogger(Pawn.class.getName());

    private ChessBoard chessBoard;
    private int xCoordinate;
    private int yCoordinate;
    private PieceColor pieceColor;

    public Pawn(PieceColor pieceColor) {
        this.pieceColor = pieceColor;
    }

    public ChessBoard getChessBoard() {
        return chessBoard;
    }

    public void setChessBoard(ChessBoard chessBoard) {
        this.chessBoard = chessBoard;
    }

    public int getXCoordinate() {
        return xCoordinate;
    }

    public void setXCoordinate(int value) {
        this.xCoordinate = value;
    }

    public int getYCoordinate() {
        return yCoordinate;
    }

    public void setYCoordinate(int value) {
        this.yCoordinate = value;
    }

    public PieceColor getPieceColor() {
        return this.pieceColor;
    }

    public void setPieceColor(PieceColor value) {
        pieceColor = value;
    }

    public void move(MovementType movementType, int newX, int newY) {
        if (!chessBoard.isLegalBoardPosition(newX, newY) || !this.isLegalBoardPosition(newX)) {
            return;
        }
        if (MovementType.MOVE.equals(movementType) && isMoveValid(newX, newY)) {
            this.setXCoordinate(newX);
            this.setYCoordinate(newY);
        }
    }

    public boolean isLegalBoardPosition(int xCoordinate) {
        boolean blackPositionValid = xCoordinate < ChessBoard.MAX_BOARD_HEIGHT - 1;
        boolean whitePositionValid = xCoordinate > 0;
        return (PieceColor.BLACK == this.pieceColor && blackPositionValid) || (PieceColor.WHITE == this.pieceColor && whitePositionValid);
    }

    private boolean isMoveValid(int newX, int newY) {
        final int whitePawnInitialPosition = 1;
        final int blackPawnInitialPosition = ChessBoard.MAX_BOARD_HEIGHT - 2;

        if (newY != this.yCoordinate) {
            logger.log(Level.INFO, "Cannot move on a different y coord: {}", newY);
            return false;
        }
        if (PieceColor.WHITE.equals(this.pieceColor)) {
            int distance = newX - this.xCoordinate;
            if (isDistanceValid(distance, whitePawnInitialPosition)){
                return false;
            }
        }
        if (PieceColor.BLACK.equals(this.pieceColor)) {
            int distance = this.xCoordinate - newX;
            if (isDistanceValid(distance, blackPawnInitialPosition)){
                return false;
            }
        }
        if (chessBoard.getPiece(newX, newY).isPresent()) {
            logger.info("Cannot move on an occupied position");
            return false;
        }
        return true;
    }

    private boolean isDistanceValid(int distance, int initialPosition) {
        boolean isDistanceValid = (this.xCoordinate == initialPosition && distance > 2) ||
                (this.xCoordinate != initialPosition && distance != 1);
        if (isDistanceValid) {
            logger.log(Level.INFO, "Cannot move {} positions", distance);
        }
        return isDistanceValid;
    }

    @Override
    public String toString() {
        return getCurrentPositionAsString();
    }

    protected String getCurrentPositionAsString() {
        String eol = System.lineSeparator();
        return String.format("Current X: {1}{0}Current Y: {2}{0}Piece Color: {3}", eol, xCoordinate, yCoordinate, pieceColor);
    }
}
