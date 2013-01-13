=============================
Android video stream rotation
=============================

:author: Grzegorz Adam Hankiewicz <gradha@imap.cc>

.. contents::

.. section-numbering::

General
=======

This test contains a limited video player able to stream a .3gp file from
internet. The video will be shown centered full screen, maintaining the video
aspect ratio. Also, rotations don't interrupt the video, which keeps playing
without problems.

The test was created because I had video corruption problems on my HTC Legend
device (see
<http://stackoverflow.com/questions/6524659/avoid-android-videoview-corruption-when-rotating-back-to-portrait>).
However it turns out the problem was with how I handled rotation and *escaping*
into using a custom video view was **not** the solution.

I'm leaving this repo here, but I won't be updating it or changing it further.
Other people have found this useful and started doing improvements on it (see
<https://github.com/gradha/Android-video-stream-rotation/pull/1>). You can
check <https://github.com/gradha/Android-video-stream-rotation/network> to see
the whole list of forks and possible improvements.


Source code
===========

Requirements
------------

The source code is meant for API level 7 and above, though it may run on lower
SDK versions. I've tested this on an HTC Legend.


License
-------

This code is available under the BSD license
(<http://www.opensource.org/licenses/bsd-license.php>).

Copyright (c) 2013, Grzegorz Adam Hankiewicz.
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
