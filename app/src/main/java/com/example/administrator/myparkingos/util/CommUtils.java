package com.example.administrator.myparkingos.util;

/**
 * Created by Administrator on 2017-03-20.
 */
public class CommUtils
{
    /**
     * "88" + (max + 1).ToString().PadLeft(6, '0');
     *
     * @return
     */

    //
    // 摘要:
    //     返回一个新字符串，该字符串通过在此实例中的字符左侧填充指定的 Unicode 字符来达到指定的总长度，从而使这些字符右对齐。
    //
    // 参数:
    //   totalWidth:
    //     结果字符串中的字符数，等于原始字符数加上任何其他填充字符。
    //
    //   paddingChar:
    //     Unicode 填充字符。
    //
    // 返回结果:
    //     与此实例等效的一个新字符串，但该字符串为右对齐，因此，在左侧填充所需任意数量的 paddingChar 字符，使长度达到 totalWidth。
    //     但是，如果 totalWidth 小于此事例的长度，则方法将返回对现有实例的引用。 如果 totalWidth 等于此实例的长度，则返回为与此实例相同的新字符串。
    //
    // 异常:
    //   System.ArgumentOutOfRangeException:
    //     totalWidth 小于零。
    public static String stringPadLeft(String source, int totalWidth, char paddingChar)
    {
        if (totalWidth < 0)
        {
            throw new ArrayIndexOutOfBoundsException("totalWidth < 0");
        }

        if (source.length() > totalWidth)
        {
            return source;
        }
        else if (source.length() == totalWidth)
        {
            return new String(source);
        }
        else
        {
            StringBuffer stringBuffer = new StringBuffer(); // 12  6 '0'
            for (int i = 0; i < totalWidth - source.length(); i++)
            {
                stringBuffer.append(paddingChar);
            }
            return stringBuffer.append(source).toString();
        }
    }


    public static boolean CheckUpCPH(String strCPH)
    {
        if (null == strCPH || (strCPH.length() != 7 && strCPH.length() != 8))
        {
            return false;
        }
        else if (strCPH.length() == 8)
        {
            if (strCPH.substring(0, 2 + 0).toUpperCase().equals("WJ"))
            {
                return false;
            }
            else
            {
                String cphHead = "京津冀晋蒙辽吉黑沪苏浙皖闽赣鲁豫鄂湘粤桂琼渝川贵云藏陕甘青宁新港澳台警军空海北沈兰济南广成";
                if (cphHead.contains(strCPH.substring(2, 1 + 2)))
                {
                    if (RegexUtil.IsLetterOrFigureNotIO(strCPH.substring(3)))
//                    if (CR.IsLetterOrFigureNotIO(strCPH.substring(3)))
                    {
                        return true;
                    }
                    else
                    {
                        return false;
                    }
                }
                else
                {
                    return false;
                }
            }
        }
        else
        {
            String cphHead = "京津冀晋蒙辽吉黑沪苏浙皖闽赣鲁豫鄂湘粤桂琼渝川贵云藏陕甘青宁新港澳台警军空海北沈兰济南广成";
            if (cphHead.contains(strCPH.substring(0, 1 + 0)))
            {
                if (RegexUtil.IsLetterNotIO(strCPH.substring(1, 1 + 1)))
//                if (CR.IsLetterNotIO(strCPH.substring(1, 1 + 1)))
                {
                    if (RegexUtil.IsLetterOrFigureNotIO(strCPH.substring(2, 4 + 2)))
//                    if (CR.IsLetterOrFigureNotIO(strCPH.substring(2, 4 + 2)))
                    {
                        String strCphHead = "港澳警学领ABCDEFGHJKLMNPQRSTUVWXYZabcdefghjklmnpqrstuvwxyz0123456789";
                        if (strCphHead.contains(strCPH.substring(6, 1 + 6)))
                        {
                            return true;
                        }
                        else
                        {
                            return false;
                        }
                    }
                    else
                    {
                        return false;
                    }
                }
                else
                {
                    return false;
                }
            }
            else
            {
                return false;
            }
        }
    }
}
