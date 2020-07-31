package com.romeo.chess;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class PawnTest {

    private ChessBoard chessBoard;
    private Pawn testSubjectBlack;
    private Pawn testSubjectWhite;


    @Before
    public void setUp() {
        this.chessBoard = new ChessBoard();
        this.testSubjectBlack = new Pawn(PieceColor.BLACK);
        this.testSubjectWhite = new Pawn(PieceColor.WHITE);
    }

    @Test
    public void testChessBoardAddSetsXCoordinate() {
        this.chessBoard.addPiece(testSubjectBlack, 6, 3);
        assertEquals(6, testSubjectBlack.getXCoordinate());
    }

    @Test
    public void testChessBoardAddSetsYCoordinate() {
        this.chessBoard.addPiece(testSubjectBlack, 6, 3);
        assertEquals(3, testSubjectBlack.getYCoordinate());
    }


    @Test
    public void testPawnMoveIllegalCoordinatesRightDoesNotMove() {
        chessBoard.addPiece(testSubjectBlack, 6, 3);
        testSubjectBlack.move(MovementType.MOVE, 6, 4);
        assertEquals(6, testSubjectBlack.getXCoordinate());
        assertEquals(3, testSubjectBlack.getYCoordinate());
    }

    @Test
    public void testPawnMoveIllegalCoordinatesLeftDoesNotMove() {
        chessBoard.addPiece(testSubjectBlack, 6, 3);
        testSubjectBlack.move(MovementType.MOVE, 6, 2);
        assertEquals(6, testSubjectBlack.getXCoordinate());
        assertEquals(3, testSubjectBlack.getYCoordinate());
    }

    @Test
    public void testPawnMoveLegalCoordinatesForwardUpdatesCoordinates() {
        chessBoard.addPiece(testSubjectBlack, 6, 3);
        testSubjectBlack.move(MovementType.MOVE, 5, 3);
        assertEquals(5, testSubjectBlack.getXCoordinate());
        assertEquals(3, testSubjectBlack.getYCoordinate());
    }

    @Test
    public void testWhitePawnMoveIllegalCoordinatesRightDoesNotMove() {
        chessBoard.addPiece(testSubjectWhite, 1, 6);
        testSubjectWhite.move(MovementType.MOVE, 1, 7);
        assertEquals(1, testSubjectWhite.getXCoordinate());
        assertEquals(6, testSubjectWhite.getYCoordinate());
    }

    @Test
    public void testWhitePawnMoveIllegalCoordinatesLeftDoesNotMove() {
        chessBoard.addPiece(testSubjectWhite, 1, 6);
        testSubjectWhite.move(MovementType.MOVE, 1, 5);
        assertEquals(1, testSubjectWhite.getXCoordinate());
        assertEquals(6, testSubjectWhite.getYCoordinate());
    }

    @Test
    public void testWhitePawnMoveLegalCoordinatesForwardFromInitialUpdatesCoordinates() {
        chessBoard.addPiece(testSubjectWhite, 1, 6);
        testSubjectWhite.move(MovementType.MOVE, 2, 6);
        assertEquals(2, testSubjectWhite.getXCoordinate());
        assertEquals(6, testSubjectWhite.getYCoordinate());
    }

    @Test
    public void testWhitePawnMoveLegalCoordinatesForwardTwoPositionsFromInitialUpdatesCoordinates() {
        chessBoard.addPiece(testSubjectWhite, 1, 6);
        testSubjectWhite.move(MovementType.MOVE, 3, 6);
        assertEquals(3, testSubjectWhite.getXCoordinate());
        assertEquals(6, testSubjectWhite.getYCoordinate());
    }

    @Test
    public void testWhitePawnMoveIllegalCoordinatesForwardThreePositionsFromInitial() {
        chessBoard.addPiece(testSubjectWhite, 1, 6);
        testSubjectWhite.move(MovementType.MOVE, 4, 6);
        assertEquals(1, testSubjectWhite.getXCoordinate());
        assertEquals(6, testSubjectWhite.getYCoordinate());
    }

    @Test
    public void testWhitePawnMoveLegalCoordinatesForward() {
        chessBoard.addPiece(testSubjectWhite, 2, 6);
        testSubjectWhite.move(MovementType.MOVE, 3, 6);
        assertEquals(3, testSubjectWhite.getXCoordinate());
        assertEquals(6, testSubjectWhite.getYCoordinate());
    }

    @Test
    public void testWhitePawnMoveIlegalCoordinatesForwardTwoPositions() {
        chessBoard.addPiece(testSubjectWhite, 2, 6);
        testSubjectWhite.move(MovementType.MOVE, 4, 6);
        assertEquals(2, testSubjectWhite.getXCoordinate());
        assertEquals(6, testSubjectWhite.getYCoordinate());
    }

}
