""" Python Character Mapping Codec generated from '8859-2.TXT' with gencodec.py.

Written by Marc-Andre Lemburg (mal@lemburg.com).

(c) Copyright CNRI, All Rights Reserved. NO WARRANTY.
(c) Copyright 2000 Guido van Rossum.

"""#"

import codecs

### Codec APIs

class Codec(codecs.Codec):

    def encode(self,input,errors='strict'):

        return codecs.charmap_encode(input,errors,encoding_map)
        
    def decode(self,input,errors='strict'):

        return codecs.charmap_decode(input,errors,decoding_map)

class StreamWriter(Codec,codecs.StreamWriter):
    pass
        
class StreamReader(Codec,codecs.StreamReader):
    pass

### encodings module API

def getregentry():

    return (Codec().encode,Codec().decode,StreamReader,StreamWriter)

### Decoding Map

decoding_map = codecs.make_identity_dict(range(256))
decoding_map.update({
	0x00a1: 0x0104,	# 	LATIN CAPITAL LETTER A WITH OGONEK
	0x00a2: 0x02d8,	# 	BREVE
	0x00a3: 0x0141,	# 	LATIN CAPITAL LETTER L WITH STROKE
	0x00a5: 0x013d,	# 	LATIN CAPITAL LETTER L WITH CARON
	0x00a6: 0x015a,	# 	LATIN CAPITAL LETTER S WITH ACUTE
	0x00a9: 0x0160,	# 	LATIN CAPITAL LETTER S WITH CARON
	0x00aa: 0x015e,	# 	LATIN CAPITAL LETTER S WITH CEDILLA
	0x00ab: 0x0164,	# 	LATIN CAPITAL LETTER T WITH CARON
	0x00ac: 0x0179,	# 	LATIN CAPITAL LETTER Z WITH ACUTE
	0x00ae: 0x017d,	# 	LATIN CAPITAL LETTER Z WITH CARON
	0x00af: 0x017b,	# 	LATIN CAPITAL LETTER Z WITH DOT ABOVE
	0x00b1: 0x0105,	# 	LATIN SMALL LETTER A WITH OGONEK
	0x00b2: 0x02db,	# 	OGONEK
	0x00b3: 0x0142,	# 	LATIN SMALL LETTER L WITH STROKE
	0x00b5: 0x013e,	# 	LATIN SMALL LETTER L WITH CARON
	0x00b6: 0x015b,	# 	LATIN SMALL LETTER S WITH ACUTE
	0x00b7: 0x02c7,	# 	CARON
	0x00b9: 0x0161,	# 	LATIN SMALL LETTER S WITH CARON
	0x00ba: 0x015f,	# 	LATIN SMALL LETTER S WITH CEDILLA
	0x00bb: 0x0165,	# 	LATIN SMALL LETTER T WITH CARON
	0x00bc: 0x017a,	# 	LATIN SMALL LETTER Z WITH ACUTE
	0x00bd: 0x02dd,	# 	DOUBLE ACUTE ACCENT
	0x00be: 0x017e,	# 	LATIN SMALL LETTER Z WITH CARON
	0x00bf: 0x017c,	# 	LATIN SMALL LETTER Z WITH DOT ABOVE
	0x00c0: 0x0154,	# 	LATIN CAPITAL LETTER R WITH ACUTE
	0x00c3: 0x0102,	# 	LATIN CAPITAL LETTER A WITH BREVE
	0x00c5: 0x0139,	# 	LATIN CAPITAL LETTER L WITH ACUTE
	0x00c6: 0x0106,	# 	LATIN CAPITAL LETTER C WITH ACUTE
	0x00c8: 0x010c,	# 	LATIN CAPITAL LETTER C WITH CARON
	0x00ca: 0x0118,	# 	LATIN CAPITAL LETTER E WITH OGONEK
	0x00cc: 0x011a,	# 	LATIN CAPITAL LETTER E WITH CARON
	0x00cf: 0x010e,	# 	LATIN CAPITAL LETTER D WITH CARON
	0x00d0: 0x0110,	# 	LATIN CAPITAL LETTER D WITH STROKE
	0x00d1: 0x0143,	# 	LATIN CAPITAL LETTER N WITH ACUTE
	0x00d2: 0x0147,	# 	LATIN CAPITAL LETTER N WITH CARON
	0x00d5: 0x0150,	# 	LATIN CAPITAL LETTER O WITH DOUBLE ACUTE
	0x00d8: 0x0158,	# 	LATIN CAPITAL LETTER R WITH CARON
	0x00d9: 0x016e,	# 	LATIN CAPITAL LETTER U WITH RING ABOVE
	0x00db: 0x0170,	# 	LATIN CAPITAL LETTER U WITH DOUBLE ACUTE
	0x00de: 0x0162,	# 	LATIN CAPITAL LETTER T WITH CEDILLA
	0x00e0: 0x0155,	# 	LATIN SMALL LETTER R WITH ACUTE
	0x00e3: 0x0103,	# 	LATIN SMALL LETTER A WITH BREVE
	0x00e5: 0x013a,	# 	LATIN SMALL LETTER L WITH ACUTE
	0x00e6: 0x0107,	# 	LATIN SMALL LETTER C WITH ACUTE
	0x00e8: 0x010d,	# 	LATIN SMALL LETTER C WITH CARON
	0x00ea: 0x0119,	# 	LATIN SMALL LETTER E WITH OGONEK
	0x00ec: 0x011b,	# 	LATIN SMALL LETTER E WITH CARON
	0x00ef: 0x010f,	# 	LATIN SMALL LETTER D WITH CARON
	0x00f0: 0x0111,	# 	LATIN SMALL LETTER D WITH STROKE
	0x00f1: 0x0144,	# 	LATIN SMALL LETTER N WITH ACUTE
	0x00f2: 0x0148,	# 	LATIN SMALL LETTER N WITH CARON
	0x00f5: 0x0151,	# 	LATIN SMALL LETTER O WITH DOUBLE ACUTE
	0x00f8: 0x0159,	# 	LATIN SMALL LETTER R WITH CARON
	0x00f9: 0x016f,	# 	LATIN SMALL LETTER U WITH RING ABOVE
	0x00fb: 0x0171,	# 	LATIN SMALL LETTER U WITH DOUBLE ACUTE
	0x00fe: 0x0163,	# 	LATIN SMALL LETTER T WITH CEDILLA
	0x00ff: 0x02d9,	# 	DOT ABOVE
})

### Encoding Map

encoding_map = codecs.make_encoding_map(decoding_map)
