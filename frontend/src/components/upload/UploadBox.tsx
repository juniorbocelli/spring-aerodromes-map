import React from 'react';
import { useDropzone } from 'react-dropzone';
// @mui
import { styled, alpha } from '@mui/material/styles';
//
import uuidv4 from 'src/utils/uuidv4';
import { Iconify } from '../iconify';
//
import { UploadProps } from './types';


// ----------------------------------------------------------------------

const StyledDropZone = styled('div')(({ theme }) => ({
  width: 64,
  height: 64,
  fontSize: 24,
  display: 'flex',
  flexShrink: 0,
  cursor: 'pointer',
  alignItems: 'center',
  justifyContent: 'center',
  margin: theme.spacing(0.5),
  color: theme.palette.text.disabled,
  borderRadius: theme.shape.borderRadius,
  border: `dashed 1px ${theme.palette.divider}`,
  backgroundColor: alpha(theme.palette.grey[500], 0.08),
  '&:hover': {
    opacity: 0.72,
  },
}));

// ----------------------------------------------------------------------

export default function UploadBox({
  placeholder,
  error,
  disabled,
  multiple = false,
  showFilesList,
  file,
  files,
  onUpload,
  sx,
  ...other }: UploadProps) {
  const { getRootProps, getInputProps, isDragActive, isDragReject, acceptedFiles, fileRejections } = useDropzone({
    multiple,
    disabled,
    ...other,
  });

  const hasFile = !!file && !multiple;

  const hasFiles = files && multiple && files.length > 0;

  const isError = isDragReject || error;

  const FilesList = React.useMemo(() => (
    <ul>
      {files?.map((f) => <li key={uuidv4()}>{f instanceof File ? `${f.name} ${f.size}` : f}</li>)}
    </ul>


  ), [files]);

  return (
    <>
      <StyledDropZone
        {...getRootProps()}
        sx={{
          ...(isDragActive && {
            opacity: 0.72,
          }),
          ...(isError && {
            color: 'error.main',
            bgcolor: 'error.lighter',
            borderColor: 'error.light',
          }),
          ...(disabled && {
            opacity: 0.48,
            pointerEvents: 'none',
          }),
          ...sx,
        }}
      >
        <input {...getInputProps()} />

        {placeholder || <Iconify icon="eva:cloud-upload-fill" width={28} />}
      </StyledDropZone>

      {showFilesList && hasFiles ? FilesList : null}
      {showFilesList && hasFile ?
        (
          <ul>
            <li key={uuidv4()}>{file instanceof File ? `${file.name} - ${file.size} bytes` : file}</li>
          </ul>
        ) : null}
    </>
  );
}
