import axios from 'src/utils/axios';

export function uploadFilesAPI(image: FormData, route: string) {
  return axios.post(route, image, {
    headers: {
      "Content-Type": `multipart/form-data; boundary=&`,
    },
    transformRequest: (data, headers) => image
  });
};