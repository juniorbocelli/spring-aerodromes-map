import React from 'react';
// @mui
import { SxProps, styled } from '@mui/material/styles';
import Table from '@mui/material/Table';
import TableBody from '@mui/material/TableBody';
import TableCell, { tableCellClasses } from '@mui/material/TableCell';
import TableContainer from '@mui/material/TableContainer';
import TableHead from '@mui/material/TableHead';
import TableRow from '@mui/material/TableRow';
import Paper from '@mui/material/Paper';

// @types
import { IRunway } from 'src/@types/runway';
//
import uuidv4 from 'src/utils/uuidv4';

// ----------------------------------------------------------------------

const StyledTableCell = styled(TableCell)(({ theme }) => ({
  [`&.${tableCellClasses.head}`]: {
    backgroundColor: theme.palette.common.black,
    color: theme.palette.common.white,
  },
  [`&.${tableCellClasses.body}`]: {
    fontSize: 14,
  },
}));

const StyledTableRow = styled(TableRow)(({ theme }) => ({
  '&:nth-of-type(odd)': {
    backgroundColor: theme.palette.action.hover,
  },
  // hide last border
  '&:last-child td, &:last-child th': {
    border: 0,
  },
}));

// ----------------------------------------------------------------------

interface IRunwaysTableProps {
  runways: IRunway[];
  sx?: SxProps;
};

const RunwaysTable: React.FC<IRunwaysTableProps> = ({ runways, sx }) => (
  <TableContainer component={Paper}>
    <Table sx={{ ...sx }} aria-label="customized table" size="small">
      <TableHead>
        <TableRow>
          <StyledTableCell>Designação</StyledTableCell>
          <StyledTableCell>Largura (m)</StyledTableCell>
          <StyledTableCell>Comprimento (m)</StyledTableCell>
        </TableRow>
      </TableHead>
      <TableBody>
        {runways.map((r) => (
          <StyledTableRow key={uuidv4()}>
            <StyledTableCell component="th" scope="row">
              {r.designation}
            </StyledTableCell>
            <StyledTableCell>{r.width}</StyledTableCell>
            <StyledTableCell>{r.length}</StyledTableCell>
          </StyledTableRow>
        ))}
      </TableBody>
    </Table>
  </TableContainer>
);

export default RunwaysTable;