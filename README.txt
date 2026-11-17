Tissaria (Fabric 1.20.1)
==========================
Mod id: tissaria  (separate from the luannouncements mod, so both can be installed together)
Adds two blocks (creative inventory > Functional Blocks):
  Tissaria Tunnel Sound  /give @s tissaria:tunnel_sound
  TISSARIA             /give @s tissaria:tissaria
Once placed, each one plays its sound all the way through, then loops forever.
TISSARIA has volume 3.0 (audible up to about 48 blocks).

Build online: upload everything here to a NEW GitHub repository, create
.github/workflows/build.yml by hand if it will not upload, open the Actions tab,
wait for the green tick, download the "tissaria" artifact.

Tweaks (src/main/java/net/tissaria/TissariaMod.java):
    Each block has two numbers: the sound length in ticks (seconds x 20) and the volume / range
    (1.0f = about 16 blocks, 3.0f = about 48).

Credit: the block texture is copied from the MTR London Underground Addon (MIT licence, t1NbLu3).
