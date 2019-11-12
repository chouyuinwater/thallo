package com.fish.base.type;

public class ByteLearn {
    public static void learn() {
        /**
         * Java也提供了一个byte数据类型，并且是基本类型。java byte是做为最小的数字来处理的，因此它的值域被定义为-128~127，也就是signed byte。
         * 下面这篇文章主要给大家介绍了关于java中byte类型的相关资料，需要的朋友可以参考下。
         * 介绍
         * byte，即字节，由8位的二进制组成。在Java中，byte类型的数据是8位带符号的二进制数。
         * 在计算机中，8位带符号二进制数的取值范围是[-128, 127]，所以在Java中，byte类型的取值范围也是[-128, 127]。
         * 取值范围分析
         * 一直在想为什么不是 -128 到 128呢？今天分析了一下这个问题。
         * 首先我们得明白一件事情，那就是运算规则：
         * ####正数的最高位都是 0 ，正数的值就是二进制表示的值。 ####
         * ####负数的最高位都是 1 ，负数的值是 取反后加一 然后加个负号得到得值。 ####
         * 我们用8位的二进制来说明一下此规则：
         * 比如：00000001。最高位是0 为正数 ，那么表示的就是 十进制的 1。
         * 再比如：10000001.最高位是1 为负数，值是多少？取反得到 01111110 加1 得到 01111111 ，那么值为 -127
         * 理解此运算规则我们正式开始说byte，byte正好是8位的二进制数。short是16位 int是32位 long是64位。
         * 不难理解，byte的最大正数就是 01111111（最高位必须是0），也就是 127。
         * 那么你可能会想 byte的最小负数就是 11111111 了，对不对? 这么想就
         * 大错特错了。让我们看看11111111这个二进制数表示多少。
         * 根据上面的提示 我们知道这是一个负数。它的值是先取反再加1 。
         * 11111111取反得到：00000000，加1得到 00000001 。最后得到的值为-1.
         * 这可是最大的负数啊。由此你是不是想到了最小的负数会不会是10000000呢？
         * 让我们算一下 取反：01111111 加1得到 10000000 最后得到 -128.
         * 127是01111111 然而 -128是10000000 ，看出来一个奇怪的事情。
         *
         */

        // Return the maximum length of an array of BasicType.  The length can passed
        // to typeArrayOop::object_size(scale, length, header_size) without causing an
        // overflow. We also need to make sure that this will not overflow a size_t on
        // 32 bit platforms when we convert it to a byte size.
//        static int32_t max_array_length(BasicType type) {
//            // 判断数据类型是否正确
//            assert(type >= 0 && type < T_CONFLICT, "wrong type");
//            assert(type2aelembytes(type) != 0, "wrong type");
//
//        const size_t max_element_words_per_size_t =
//                    align_down((SIZE_MAX/HeapWordSize - header_size(type)), MinObjAlignment);
//        const size_t max_elements_per_size_t =
//                    HeapWordSize * max_element_words_per_size_t / type2aelembytes(type);
//            if ((size_t)max_jint < max_elements_per_size_t) {
//                // It should be ok to return max_jint here, but parts of the code
//                // (CollectedHeap, Klass::oop_oop_iterate(), and more) uses an int for
//                // passing around the size (in words) of an object. So, we need to avoid
//                // overflowing an int when we add the header. See CRs 4718400 and 7110613.
//                return align_down(max_jint - header_size(type), MinObjAlignment);
//            }
//            return (int32_t)max_elements_per_size_t;
//        }
    }
}
