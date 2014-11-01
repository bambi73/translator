/*
 * Copyright (c) 2009, Giuseppe Cardone <ippatsuman@gmail.com>
 * All rights reserved.
 * Redistribution and use in source and binary forms, with or without
 * modification, are permitted provided that the following conditions are met:
 *  * Redistributions of source code must retain the above copyright
 *    notice, this list of conditions and the following disclaimer.
 *  * Redistributions in binary form must reproduce the above copyright
 *    notice, this list of conditions and the following disclaimer in the
 *    documentation and/or other materials provided with the distribution.
 *  * Neither the name of the author nor the names of the contributors may be
 *    used to endorse or promote products derived from this software without
 *    specific prior written permission.
 *
 * THIS SOFTWARE IS PROVIDED BY GIUSEPPE CARDONE ''AS IS'' AND ANY
 * EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE IMPLIED
 * WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE ARE
 * DISCLAIMED. IN NO EVENT SHALL GIUSEPPE CARDONE BE LIABLE FOR ANY
 * DIRECT, INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR CONSEQUENTIAL DAMAGES
 * (INCLUDING, BUT NOT LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR SERVICES;
 * LOSS OF USE, DATA, OR PROFITS; OR BUSINESS INTERRUPTION) HOWEVER CAUSED AND
 * ON ANY THEORY OF LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY, OR TORT
 * (INCLUDING NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE OF THIS
 * SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.
 *
 */
package net.sf.junidecode;

/**
 * Character map for Unicode characters with codepoint U+12xx.
 * @author Giuseppe Cardone
 * @version 0.1
 */
class X12 {

    public static final String[] map = new String[]{
        "ha", // 0x00
        "hu", // 0x01
        "hi", // 0x02
        "haa", // 0x03
        "hee", // 0x04
        "he", // 0x05
        "ho", // 0x06
        "[?]", // 0x07
        "la", // 0x08
        "lu", // 0x09
        "li", // 0x0a
        "laa", // 0x0b
        "lee", // 0x0c
        "le", // 0x0d
        "lo", // 0x0e
        "lwa", // 0x0f
        "hha", // 0x10
        "hhu", // 0x11
        "hhi", // 0x12
        "hhaa", // 0x13
        "hhee", // 0x14
        "hhe", // 0x15
        "hho", // 0x16
        "hhwa", // 0x17
        "ma", // 0x18
        "mu", // 0x19
        "mi", // 0x1a
        "maa", // 0x1b
        "mee", // 0x1c
        "me", // 0x1d
        "mo", // 0x1e
        "mwa", // 0x1f
        "sza", // 0x20
        "szu", // 0x21
        "szi", // 0x22
        "szaa", // 0x23
        "szee", // 0x24
        "sze", // 0x25
        "szo", // 0x26
        "szwa", // 0x27
        "ra", // 0x28
        "ru", // 0x29
        "ri", // 0x2a
        "raa", // 0x2b
        "ree", // 0x2c
        "re", // 0x2d
        "ro", // 0x2e
        "rwa", // 0x2f
        "sa", // 0x30
        "su", // 0x31
        "si", // 0x32
        "saa", // 0x33
        "see", // 0x34
        "se", // 0x35
        "so", // 0x36
        "swa", // 0x37
        "sha", // 0x38
        "shu", // 0x39
        "shi", // 0x3a
        "shaa", // 0x3b
        "shee", // 0x3c
        "she", // 0x3d
        "sho", // 0x3e
        "shwa", // 0x3f
        "qa", // 0x40
        "qu", // 0x41
        "qi", // 0x42
        "qaa", // 0x43
        "qee", // 0x44
        "qe", // 0x45
        "qo", // 0x46
        "[?]", // 0x47
        "qwa", // 0x48
        "[?]", // 0x49
        "qwi", // 0x4a
        "qwaa", // 0x4b
        "qwee", // 0x4c
        "qwe", // 0x4d
        "[?]", // 0x4e
        "[?]", // 0x4f
        "qha", // 0x50
        "qhu", // 0x51
        "qhi", // 0x52
        "qhaa", // 0x53
        "qhee", // 0x54
        "qhe", // 0x55
        "qho", // 0x56
        "[?]", // 0x57
        "qhwa", // 0x58
        "[?]", // 0x59
        "qhwi", // 0x5a
        "qhwaa", // 0x5b
        "qhwee", // 0x5c
        "qhwe", // 0x5d
        "[?]", // 0x5e
        "[?]", // 0x5f
        "ba", // 0x60
        "bu", // 0x61
        "bi", // 0x62
        "baa", // 0x63
        "bee", // 0x64
        "be", // 0x65
        "bo", // 0x66
        "bwa", // 0x67
        "va", // 0x68
        "vu", // 0x69
        "vi", // 0x6a
        "vaa", // 0x6b
        "vee", // 0x6c
        "ve", // 0x6d
        "vo", // 0x6e
        "vwa", // 0x6f
        "ta", // 0x70
        "tu", // 0x71
        "ti", // 0x72
        "taa", // 0x73
        "tee", // 0x74
        "te", // 0x75
        "to", // 0x76
        "twa", // 0x77
        "ca", // 0x78
        "cu", // 0x79
        "ci", // 0x7a
        "caa", // 0x7b
        "cee", // 0x7c
        "ce", // 0x7d
        "co", // 0x7e
        "cwa", // 0x7f
        "xa", // 0x80
        "xu", // 0x81
        "xi", // 0x82
        "xaa", // 0x83
        "xee", // 0x84
        "xe", // 0x85
        "xo", // 0x86
        "[?]", // 0x87
        "xwa", // 0x88
        "[?]", // 0x89
        "xwi", // 0x8a
        "xwaa", // 0x8b
        "xwee", // 0x8c
        "xwe", // 0x8d
        "[?]", // 0x8e
        "[?]", // 0x8f
        "na", // 0x90
        "nu", // 0x91
        "ni", // 0x92
        "naa", // 0x93
        "nee", // 0x94
        "ne", // 0x95
        "no", // 0x96
        "nwa", // 0x97
        "nya", // 0x98
        "nyu", // 0x99
        "nyi", // 0x9a
        "nyaa", // 0x9b
        "nyee", // 0x9c
        "nye", // 0x9d
        "nyo", // 0x9e
        "nywa", // 0x9f
        "\'a", // 0xa0
        "\'u", // 0xa1
        "[?]", // 0xa2
        "\'aa", // 0xa3
        "\'ee", // 0xa4
        "\'e", // 0xa5
        "\'o", // 0xa6
        "\'wa", // 0xa7
        "ka", // 0xa8
        "ku", // 0xa9
        "ki", // 0xaa
        "kaa", // 0xab
        "kee", // 0xac
        "ke", // 0xad
        "ko", // 0xae
        "[?]", // 0xaf
        "kwa", // 0xb0
        "[?]", // 0xb1
        "kwi", // 0xb2
        "kwaa", // 0xb3
        "kwee", // 0xb4
        "kwe", // 0xb5
        "[?]", // 0xb6
        "[?]", // 0xb7
        "kxa", // 0xb8
        "kxu", // 0xb9
        "kxi", // 0xba
        "kxaa", // 0xbb
        "kxee", // 0xbc
        "kxe", // 0xbd
        "kxo", // 0xbe
        "[?]", // 0xbf
        "kxwa", // 0xc0
        "[?]", // 0xc1
        "kxwi", // 0xc2
        "kxwaa", // 0xc3
        "kxwee", // 0xc4
        "kxwe", // 0xc5
        "[?]", // 0xc6
        "[?]", // 0xc7
        "wa", // 0xc8
        "wu", // 0xc9
        "wi", // 0xca
        "waa", // 0xcb
        "wee", // 0xcc
        "we", // 0xcd
        "wo", // 0xce
        "[?]", // 0xcf
        "`a", // 0xd0
        "`u", // 0xd1
        "`i", // 0xd2
        "`aa", // 0xd3
        "`ee", // 0xd4
        "`e", // 0xd5
        "`o", // 0xd6
        "[?]", // 0xd7
        "za", // 0xd8
        "zu", // 0xd9
        "zi", // 0xda
        "zaa", // 0xdb
        "zee", // 0xdc
        "ze", // 0xdd
        "zo", // 0xde
        "zwa", // 0xdf
        "zha", // 0xe0
        "zhu", // 0xe1
        "zhi", // 0xe2
        "zhaa", // 0xe3
        "zhee", // 0xe4
        "zhe", // 0xe5
        "zho", // 0xe6
        "zhwa", // 0xe7
        "ya", // 0xe8
        "yu", // 0xe9
        "yi", // 0xea
        "yaa", // 0xeb
        "yee", // 0xec
        "ye", // 0xed
        "yo", // 0xee
        "[?]", // 0xef
        "da", // 0xf0
        "du", // 0xf1
        "di", // 0xf2
        "daa", // 0xf3
        "dee", // 0xf4
        "de", // 0xf5
        "do", // 0xf6
        "dwa", // 0xf7
        "dda", // 0xf8
        "ddu", // 0xf9
        "ddi", // 0xfa
        "ddaa", // 0xfb
        "ddee", // 0xfc
        "dde", // 0xfd
        "ddo", // 0xfe
        "ddwa" // 0xff
    };
}
