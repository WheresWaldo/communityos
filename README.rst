.. image:: https://raw.githubusercontent.com/WheresWaldo/CommunityOS/master/media/communityos.png
.. :scale: 50 %
.. :alt: CommunityOS logo

A replacement distribution for Robo3D R2 and C2 printers. It includes the `OctoPrint <http://octoprint.org>`_ host software for 3d printers out of the box and `mjpg-streamer with RaspiCam support <https://github.com/jacksonliam/mjpg-streamer>`_ for live viewing of prints and timelapse video creation.

This repository contains the source script to generate the distribution out of an existing `Raspbian <http://www.raspbian.org/>`_ distro image.

Features
--------

* `OctoPrint <http://octoprint.org>`_ host software for 3d printers out of the box
* `Raspbian <http://www.raspbian.org/>`_ tweaked for maximum performance for printing out of the box
* `mjpg-streamer with RaspiCam support <https://github.com/jacksonliam/mjpg-streamer>`_ for live viewing of prints and timelapse video creation.
* `HAProxy & unique hostname` for .local access on your network
* `CuraEngine <https://github.com/Ultimaker/CuraEngine>`_ optionally pre-installed for slicing directly on the Raspberry Pi

Developing
----------

Requirements
~~~~~~~~~~~~

#. `qemu-arm-static <http://packages.debian.org/sid/qemu-user-static>`_
#. `CustomPiOS <https://github.com/guysoft/CustomPiOS>`_
#. Downloaded `Raspbian <http://www.raspbian.org/>`_ image.
#. root privileges for chroot
#. Bash
#. git
#. realpath
#. sudo (the script itself calls it, running as root without sudo won't work)

Build CommunityOS From within CommunityOS / Raspbian / Debian / Ubuntu
~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~

CommunityOS can be built on Debian, Raspbian, or even CommunityOS. Building on Debian is highly recommended and is what the release images are built on. Build requires about 6.1 GB of free space available. You can build it by issuing the following commands::

    sudo apt-get install -y gawk util-linux realpath qemu-user-static git p7zip-full python3
    git clone https://github.com/guysoft/CustomPiOS.git
    git clone -b master --depth 1 https://github.com/WheresWaldo/CommunityOS.git
    cd CommunityOS/src/image
    wget -c --trust-server-names 'https://downloads.raspberrypi.org/raspbian_lite_latest'
    cd ..
    ../../CustomPiOS/src/update-custompios-paths
    sudo modprobe loop
    sudo bash -x ./build_dist

If you would like to build on the latest version of Ubuntu or Lubuntu, you may do so with the following commands::

    sudo apt-get install -y gawk util-linux qemu-user-static git p7zip-full python3
    git clone https://github.com/guysoft/CustomPiOS.git
    git clone -b master --depth 1 https://github.com/WheresWaldo/CommunityOS.git
    cd CommunityOS/src/image
    wget -c --trust-server-names 'https://downloads.raspberrypi.org/raspbian_lite_latest'
    cd ..
    ../../CustomPiOS/src/update-custompios-paths
    sudo bash -x ./build_dist

Code contribution would be appreciated! Note that touchscreen and UI are unconfigured, so edit the appropriate config file entries just after cloning the repository.

How an enduser will use the image?
----------------------------------

#. Download the image from the repository `releases <https://github.com/WheresWaldo/CommunityOS/releases>`_ page. Latest releases are always listed at the top. 
#. Unzip the image and install it to an sd card `like any other Raspberry Pi image <https://www.raspberrypi.org/documentation/installation/installing-images/README.md>`_
#. Configure your WiFi by editing ``communityos-wpa-supplicant.txt`` on the root of the flashed card when using it like a thumb drive
#. Boot the Pi from the card
#. Log into your Pi via SSH (it is located at ``communityos.local`` `if your computer supports bonjour <https://learn.adafruit.com/bonjour-zeroconf-networking-for-windows-and-linux/overview>`_ or the IP address assigned by your router), default username is "pi", default password is "raspberry". Run ``sudo raspi-config``. Once that is open:

   a. Change the password via "Change User Password"
   b. Optionally: Change the configured timezone via "Localization Options" > "Timezone".
   c. Optionally: Change the hostname via "Network Options" > "Hostname". Your CommunityOS instance will then no longer be reachable under ``communityos.local`` but rather the hostname you chose postfixed with ``.local``, so keep that in mind.
  
   You can navigate in the menus using the arrow keys and Enter. To switch to selecting the buttons at the bottom use Tab.
   
   You do not need to expand the filesystem, current versions of CommunityOS do this automatically.

OctoPrint is located at `http://communityos.local <http://communityos.local>`_. SSL certificates are not included because self signed certificates in all modern browsers will display a warning about unsafe web sites. If you choose to create your own certificates, you can ignore this warning. Please note, no trusted certificate authorities will issue SSL certificates for .local domains.

To install plugins from the commandline instead of OctoPrint's built-in plugin manager, :code:`pip` may be found at :code:`/home/pi/OctoPrint/bin/pip`.  Thus, an example install cmd may be:  :code:`/home/pi/OctoPrint/bin/pip install <plugin-uri>`

If a USB webcam or the Raspberry Pi camera is detected, MJPG-streamer will be started automatically as webcam server. OctoPrint on CommunityOS ships with correctly configured stream and snapshot URLs already set within OctoPrint. If necessary, you can reach it under `http://communityos.local/webcam/?action=stream <communityos.local/webcam/?action=stream>`_, or directly on its configured port 8080: `http://communityos.local:8080/?action=stream <communityos.local:8080/?action=stream>`_.

CuraEngine is optional and if selected will be compiled and pre-configured with the correct path to utilize it for on-board-slicing. The new CuraEngine Legacy plugin will also be installed for access via the web interface. Just import a Cura Slicing Profile in OctoPrint's settings and start slicing directly on your Pi.
