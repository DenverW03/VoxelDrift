### How to cast rays to draw pixels

- Camera has a point in space
- resolution is constant so ray marching per pixel can be computed
- Should this be based on FOV? How would that work, each pixel could compute a propotional degree, eg if 1920x1080, pixels 0 and 1919 would compute the edged of the FOV, eg -90 deg and 90 deg. The vector ray can get the color of the first visible voxel