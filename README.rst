=============================
Android video stream rotation
=============================

:author: Grzegorz Adam Hankiewicz <gradha@elhaso.com>

.. contents::

.. section-numbering::

.. raw:: pdf

   PageBreak oneColumn

General
=======

This test contains a limited video player able to stream a .3gp file from
internet. The video will be shown centered full screen, maintaining the video
aspect ratio. Also, rotations don't interrupt the video, which keeps playing
without problems.

Everything seems fine, but... on my HTC Legend when you rotate back to
portrait, the video is corrupted, and instead of showing full screen it is
displayed at its native pixel size. But rotating again to landscape works and
is shown perfectly. Any ideas why? Unfortunately I don't have more hardware to
test this on.

I'm asking also on StackOverflow at
http://stackoverflow.com/questions/6524659/avoid-android-videoview-corruption-when-rotating-back-to-portrait 


Source code
===========

Requirements
------------

The source code is meant for API level 7 and above, though it may run on lower
SDK versions. I've tested this on an HTC Legend.


License
-------

This buggy code is available under the
BSD license (http://www.opensource.org/licenses/bsd-license.php).

Copyright (c) 2011, Grzegorz Adam Hankiewicz.
All rights reserved.

Redistribution and use in source and binary forms, with or without
modification, are permitted provided that the following conditions
are met:

* Redistributions of source code must retain the above copyright
  notice, this list of conditions and the following disclaimer.
* Redistributions in binary form must reproduce the above copyright
  notice, this list of conditions and the following disclaimer in the
  documentation and/or other materials provided with the distribution.
* Neither the name of Electric Hands Software nor the names of its
  contributors may be used to endorse or promote products derived
  from this software without specific prior written permission.

THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS
"AS IS" AND ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT
LIMITED TO, THE IMPLIED WARRANTIES OF MERCHANTABILITY AND FITNESS
FOR A PARTICULAR PURPOSE ARE DISCLAIMED. IN NO EVENT SHALL THE
COPYRIGHT HOLDER OR CONTRIBUTORS BE LIABLE FOR ANY DIRECT, INDIRECT,
INCIDENTAL, SPECIAL, EXEMPLARY, OR CONSEQUENTIAL DAMAGES (INCLUDING,
BUT NOT LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR SERVICES;
LOSS OF USE, DATA, OR PROFITS; OR BUSINESS INTERRUPTION) HOWEVER
CAUSED AND ON ANY THEORY OF LIABILITY, WHETHER IN CONTRACT, STRICT
LIABILITY, OR TORT (INCLUDING NEGLIGENCE OR OTHERWISE) ARISING IN
ANY WAY OUT OF THE USE OF THIS SOFTWARE, EVEN IF ADVISED OF THE
POSSIBILITY OF SUCH DAMAGE.
