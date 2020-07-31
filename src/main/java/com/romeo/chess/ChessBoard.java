package com.romeo.chess;

import java.util.Optional;

public class ChessBoard {

    public static final int MAX_BOARD_WIDTH = 8;
    public static final int MAX_BOARD_HEIGHT = 8;

    public static final int PAWNS_NO = 8;

    private final Pawn[][] pieces;

    private int pawnsNo;

    public ChessBoard() {
        pieces = new Pawn[MAX_BOARD_WIDTH][MAX_BOARD_HEIGHT];
    }

    public void addPiece(Pawn pawn, int xCoordinate, int yCoordinate) {
        if (!isLegalBoardPosition(xCoordinate, yCoordinate) || getPiece(xCoordinate, yCoordinate).isPresent() || pawnsNo >= PAWNS_NO) {
            pawn.setXCoordinate(-1);
            pawn.setYCoordinate(-1);
        } else {
            pieces[xCoordinate][yCoordinate] = pawn;
            pawn.setXCoordinate(xCoordinate);
            pawn.setYCoordinate(yCoordinate);
            pawn.setChessBoard(this);
            pawnsNo++;
        }
    }

    public boolean isLegalBoardPosition(int xCoordinate, int yCoordinate) {
        return xCoordinate >= 0 && xCoordinate < MAX_BOARD_HEIGHT && yCoordinate >= 0 && yCoordinate < MAX_BOARD_WIDTH;
    }

    public Optional<Pawn> getPiece(int xCoordinate, int yCoordinate) {
        return pieces[xCoordinate][yCoordinate] == null ? Optional.empty() : Optional.of(pieces[xCoordinate][yCoordinate]);
    }
}
