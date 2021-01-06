/** 
 *  This is a enum class that will store the coordinates
 *  of the map objects.
 *  
 *  @author Andrei Cruceru
 *  @version 1.0.12
 */

public enum Pointers
{
    P3(3),
    P4(4),
    P5(5),
    P6(6),
    P7(7),
    P8(8),
    P9(9),
    P10(10),
    P11(11),
    P12(12),
    P13(13),
    P14(14),
    P15(15),
    P16(16),
    P17(17),
    P18(18),
    P19(19),
    P20(20),
    P21(21),
    P22(22),
    P23(23),
    P24(24),
    P25(25),
    P26(26),
    P27(27),
    P28(28),
    P29(29),
    P30(30),
    P31(31),
    P32(32),
    P33(33),
    P34(34),
    P35(35),
    P36(36),
    P37(37),
    P38(38),
    P39(39),
    P40(40),
    P41(41),
    P42(42),
    P43(43),
    P44(44),
    P45(45);
    
    public final int value;
    
    /**
    * constructor method
    */    
    private Pointers(int value)
    {
        this.value = value;
    }
    
    /**
     * Return the coordinate.
     */
    public int getValue()
    {
        return value;
    }
}