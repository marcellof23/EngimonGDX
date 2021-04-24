//package com.ungabunga.model.entities;
//
//public enum DIRECTION {
//
//    NORTH(0,1),
//    EAST(1,0),
//    SOUTH(0,-1),
//    WEST(-1,0),
//    ;
//    private int dx, dy;
//
//    private DIRECTION(int dx, int dy) {
//        this.dx = dx;
//        this.dy = dy;
//    }
//
//    public int getDX() {
//        return this.dx;
//    }
//
//    public int getDY() {
//        return this.dy;
//    }
//
//    public static DIRECTION getOpposite(DIRECTION dir) {
//        switch (dir) {
//            case NORTH:
//                return SOUTH;
//            case SOUTH:
//                return NORTH;
//            case EAST:
//                return WEST;
//            case WEST:
//                return EAST;
//        }
//        return null;
//    }
//
//}
