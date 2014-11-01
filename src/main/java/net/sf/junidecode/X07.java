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
 * Character map for Unicode characters with codepoint U+07xx.
 * @author Giuseppe Cardone
 * @version 0.1
 */
class X07 {

    public static final String[] map = new String[]{
        "//", // 0x00
        "/", // 0x01
        ",", // 0x02
        "!", // 0x03
        "!", // 0x04
        "-", // 0x05
        ",", // 0x06
        ",", // 0x07
        ";", // 0x08
        "?", // 0x09
        "~", // 0x0a
        "{", // 0x0b
        "}", // 0x0c
        "*", // 0x0d
        "[?]", // 0x0e
        "", // 0x0f
        "\'", // 0x10
        "", // 0x11
        "b", // 0x12
        "g", // 0x13
        "g", // 0x14
        "d", // 0x15
        "d", // 0x16
        "h", // 0x17
        "w", // 0x18
        "z", // 0x19
        "H", // 0x1a
        "t", // 0x1b
        "t", // 0x1c
        "y", // 0x1d
        "yh", // 0x1e
        "k", // 0x1f
        "l", // 0x20
        "m", // 0x21
        "n", // 0x22
        "s", // 0x23
        "s", // 0x24
        "`", // 0x25
        "p", // 0x26
        "p", // 0x27
        "S", // 0x28
        "q", // 0x29
        "r", // 0x2a
        "sh", // 0x2b
        "t", // 0x2c
        "[?]", // 0x2d
        "[?]", // 0x2e
        "[?]", // 0x2f
        "a", // 0x30
        "a", // 0x31
        "a", // 0x32
        "A", // 0x33
        "A", // 0x34
        "A", // 0x35
        "e", // 0x36
        "e", // 0x37
        "e", // 0x38
        "E", // 0x39
        "i", // 0x3a
        "i", // 0x3b
        "u", // 0x3c
        "u", // 0x3d
        "u", // 0x3e
        "o", // 0x3f
        "", // 0x40
        "`", // 0x41
        "\'", // 0x42
        "", // 0x43
        "", // 0x44
        "X", // 0x45
        "Q", // 0x46
        "@", // 0x47
        "@", // 0x48
        "|", // 0x49
        "+", // 0x4a
        "[?]", // 0x4b
        "[?]", // 0x4c
        "[?]", // 0x4d
        "[?]", // 0x4e
        "[?]", // 0x4f
        "[?]", // 0x50
        "[?]", // 0x51
        "[?]", // 0x52
        "[?]", // 0x53
        "[?]", // 0x54
        "[?]", // 0x55
        "[?]", // 0x56
        "[?]", // 0x57
        "[?]", // 0x58
        "[?]", // 0x59
        "[?]", // 0x5a
        "[?]", // 0x5b
        "[?]", // 0x5c
        "[?]", // 0x5d
        "[?]", // 0x5e
        "[?]", // 0x5f
        "[?]", // 0x60
        "[?]", // 0x61
        "[?]", // 0x62
        "[?]", // 0x63
        "[?]", // 0x64
        "[?]", // 0x65
        "[?]", // 0x66
        "[?]", // 0x67
        "[?]", // 0x68
        "[?]", // 0x69
        "[?]", // 0x6a
        "[?]", // 0x6b
        "[?]", // 0x6c
        "[?]", // 0x6d
        "[?]", // 0x6e
        "[?]", // 0x6f
        "[?]", // 0x70
        "[?]", // 0x71
        "[?]", // 0x72
        "[?]", // 0x73
        "[?]", // 0x74
        "[?]", // 0x75
        "[?]", // 0x76
        "[?]", // 0x77
        "[?]", // 0x78
        "[?]", // 0x79
        "[?]", // 0x7a
        "[?]", // 0x7b
        "[?]", // 0x7c
        "[?]", // 0x7d
        "[?]", // 0x7e
        "[?]", // 0x7f
        "h", // 0x80
        "sh", // 0x81
        "n", // 0x82
        "r", // 0x83
        "b", // 0x84
        "L", // 0x85
        "k", // 0x86
        "\'", // 0x87
        "v", // 0x88
        "m", // 0x89
        "f", // 0x8a
        "dh", // 0x8b
        "th", // 0x8c
        "l", // 0x8d
        "g", // 0x8e
        "ny", // 0x8f
        "s", // 0x90
        "d", // 0x91
        "z", // 0x92
        "t", // 0x93
        "y", // 0x94
        "p", // 0x95
        "j", // 0x96
        "ch", // 0x97
        "tt", // 0x98
        "hh", // 0x99
        "kh", // 0x9a
        "th", // 0x9b
        "z", // 0x9c
        "sh", // 0x9d
        "s", // 0x9e
        "d", // 0x9f
        "t", // 0xa0
        "z", // 0xa1
        "`", // 0xa2
        "gh", // 0xa3
        "q", // 0xa4
        "w", // 0xa5
        "a", // 0xa6
        "aa", // 0xa7
        "i", // 0xa8
        "ee", // 0xa9
        "u", // 0xaa
        "oo", // 0xab
        "e", // 0xac
        "ey", // 0xad
        "o", // 0xae
        "oa", // 0xaf
        "", // 0xb0
        "[?]", // 0xb1
        "[?]", // 0xb2
        "[?]", // 0xb3
        "[?]", // 0xb4
        "[?]", // 0xb5
        "[?]", // 0xb6
        "[?]", // 0xb7
        "[?]", // 0xb8
        "[?]", // 0xb9
        "[?]", // 0xba
        "[?]", // 0xbb
        "[?]", // 0xbc
        "[?]", // 0xbd
        "[?]", // 0xbe
        "[?]", // 0xbf
        "[?]", // 0xc0
        "[?]", // 0xc1
        "[?]", // 0xc2
        "[?]", // 0xc3
        "[?]", // 0xc4
        "[?]", // 0xc5
        "[?]", // 0xc6
        "[?]", // 0xc7
        "[?]", // 0xc8
        "[?]", // 0xc9
        "[?]", // 0xca
        "[?]", // 0xcb
        "[?]", // 0xcc
        "[?]", // 0xcd
        "[?]", // 0xce
        "[?]", // 0xcf
        "[?]", // 0xd0
        "[?]", // 0xd1
        "[?]", // 0xd2
        "[?]", // 0xd3
        "[?]", // 0xd4
        "[?]", // 0xd5
        "[?]", // 0xd6
        "[?]", // 0xd7
        "[?]", // 0xd8
        "[?]", // 0xd9
        "[?]", // 0xda
        "[?]", // 0xdb
        "[?]", // 0xdc
        "[?]", // 0xdd
        "[?]", // 0xde
        "[?]", // 0xdf
        "[?]", // 0xe0
        "[?]", // 0xe1
        "[?]", // 0xe2
        "[?]", // 0xe3
        "[?]", // 0xe4
        "[?]", // 0xe5
        "[?]", // 0xe6
        "[?]", // 0xe7
        "[?]", // 0xe8
        "[?]", // 0xe9
        "[?]", // 0xea
        "[?]", // 0xeb
        "[?]", // 0xec
        "[?]", // 0xed
        "[?]", // 0xee
        "[?]", // 0xef
        "[?]", // 0xf0
        "[?]", // 0xf1
        "[?]", // 0xf2
        "[?]", // 0xf3
        "[?]", // 0xf4
        "[?]", // 0xf5
        "[?]", // 0xf6
        "[?]", // 0xf7
        "[?]", // 0xf8
        "[?]", // 0xf9
        "[?]", // 0xfa
        "[?]", // 0xfb
        "[?]", // 0xfc
        "[?]", // 0xfd
        "[?]" // 0xfe
    };
}
